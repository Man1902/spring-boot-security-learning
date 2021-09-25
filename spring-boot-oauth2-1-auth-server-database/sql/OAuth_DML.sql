INSERT INTO oauth_client_details (client_id, client_secret, web_server_redirect_uri, scope, access_token_validity, refresh_token_validity, resource_ids, authorized_grant_types, authorities)
VALUES ('myClient', '{bcrypt}$2y$12$4fLp2Dhgx197Yndvy2lWaOI3hFdVUZvt4wp847UTOyG9sdNGMGRSS', 'http://localhost:9090/login', 'READ,WRITE', '30', '86400', 'inventory,payment', 'authorization_code,password,refresh_token,implicit', '');
-----------------

