package system.authz

import future.keywords.if

default allow := false

allow := true if {

    uri = input.headers["X-Original-Uri"][_]
    method = input.headers["X-Original-Method"][_]
    uri_split = split(uri, "/")

    is_authentication
    is_authorization(uri, uri_split, method)
#    print(regex.match("^/api.+/call", uri))
#    print(regex.match("^/.+/get", uri))
}

is_authentication := true if {
    bearer_token = input.headers[Authorization][_]
    token = substring(bearer_token, count("Bearer "), -1)
    startswith(bearer_token, "Bearer ")
    io.jwt.verify_hs256(token, "secret")
    [_,payload,_] = io.jwt.decode(token)
    claims = payload["claims"]
    count(claims) != 0
}

is_authorization(uri, uri_split, method) {
    bearer_token = input.headers[Authorization][_]
    token = substring(bearer_token, count("Bearer "), -1)
    [_,payload,_] = io.jwt.decode(token)
    claims = payload["claims"]
    data_authz[uri_split[1]][method][uri] == claims[_]
}

data_authz = {
    "s1" : {
        "GET": {
            "/s1/get": "read1"
        },
        "POST": {
            "/s1/post": "save1"
        },
         "PUT": {
            "/s1/put": "update1"
         },
         "DELETE": {
            "/s1/del": "delete1"
         }
    },
    "s2" : {
        "GET": {
            "/s2/get": "read2"
        },
        "POST": {
            "/s2/post": "save2"
        },
         "PUT": {
            "/s2/put": "update2"
         },
         "DELETE": {
            "/s2/del": "delete2"
         }
    },
}