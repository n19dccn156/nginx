package policy

# Not authorized by default
# Not authorized by default
default authorized = false

authorized = true {
    count(deny) == 0
    count(allow) > 0
}

# Allow access to /public
allow["public"] {
    regex.match("^/public/.*",input.uri)
}

# Account API requires authenticated user
deny["account_api_authenticated"] {
    regex.match("^/account/.*",input.uri)
    regex.match("ANONYMOUS",input.principal)
}

# Authorize access to account
allow["account_api_authorized"] {
    regex.match("^/account/.+",input.uri)
    parts := split(input.uri,"/")
    account := parts[2]
    role := concat(":",[ "ROLE_account", "read", account] )
    role == input.authorities[i]
}