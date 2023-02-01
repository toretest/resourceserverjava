# Documentation

## Start calling
```
curl -X GET "http://localhost:9000/status" -H "accept: application/json" -H "Authorization: Bearer <access_token>"
```


logout
```
Read:
https://docs.aws.amazon.com/cognito/latest/developerguide/logout-endpoint.html

Add to the url

SenseOn APP  CLIENT ID
qnfqphkeq96ppijrcndm2kjnm


aws cognito-idp initiate-auth --region eu-west-1 --auth-flow USER_PASSWORD_AUTH --client-id qnfqphkeq96ppijrcndm2kjnm --auth-parameters USERNAME=userpoolname,PASSWORD=usernamepassword
```
NB!
Gå til App client -> Info 
Merk "USER_PASSWORD_AUTH"

Da skulle du få noe som dette:

hent ut Beared token å sendt til jwt og post man
```
eyJraWQiOiIzNjE3ck9VVzk0eWdWakVnS0RyZjVFc2FqRjc4OTRFTU5DUXpmcnZINnJjPSIsImFsZyI6IlJTMjU2In0.eyJzdWIiOiI4OTQ5YTNmZC1jMjdkLTRjYmEtYWM1MC04ODlkNDFiNWRiZWMiLCJjb2duaXRvOmdyb3VwcyI6WyJST0xFX0FETUlOIl0sImlzcyI6Imh0dHBzOlwvXC9jb2duaXRvLWlkcC5ldS13ZXN0LTEuYW1hem9uYXdzLmNvbVwvZXUtd2VzdC0xX210MW1YOEtPTSIsImNsaWVudF9pZCI6InFuZnFwaGtlcTk2cHBpanJjbmRtMmtqbm0iLCJvcmlnaW5fanRpIjoiNjdiNjI2ZDctYTZkZC00MjVlLTgyZTEtNDVlMzQ0NzhjYjU1IiwiZXZlbnRfaWQiOiIzYzYzOGQ3ZS05YTliLTRlMzktYTk3NS05MTljYjhiOTc2ODYiLCJ0b2tlbl91c2UiOiJhY2Nlc3MiLCJzY29wZSI6ImF3cy5jb2duaXRvLnNpZ25pbi51c2VyLmFkbWluIiwiYXV0aF90aW1lIjoxNjc1MjY3MjU5LCJleHAiOjE2NzUyNjc1NTksImlhdCI6MTY3NTI2NzI1OSwianRpIjoiNTc4MzQ1NjAtNzY1Zi00NWEzLWJkZTMtMmYwYWZlNjY1YTFmIiwidXNlcm5hbWUiOiJ0b3JlZ2FyZDEifQ.qR5ETOaI20P_PAGOt32V04WRqGcttENiyw7vVbApOUMRQwx3vVRpqZuBm9NgIM2qM5euRTQmUkDjRAiRG_DwQkFSA7Eaed8LZrrBFznFlJYUKibSzXgyQ6X2D5u58guQpfPHc41TKqoBp36k_Wro3uSQJ5SqNLZBA5dZPMcp5Zqb3fadZHVDeyKdi2GAKj-cyC3ggJ7blG1S_V9Ut8lGjLWdoFXZ5lutqnGVK75cuCoBF3ZkN_b9o6zuOwcRCTYTuTbyE5yKZnQAnF9_bM7jqX3rSZkxg_H7N_AjalBiLi1zA_aspIr6G12hMN9ah20z3Z5cp1K5paFXmTAO3umrXA

```
På web kopier in dette i jwt.io

Header:
```
{
  "kid": "3617rOUW94ygVjEgKDrf5EsajF7894EMNCQzfrvH6rc=",
  "alg": "RS256"
}
```

Payload:
```json
{
  "sub": "8949a3fd-c27d-4cba-ac50-889d41b5dbec",
  "cognito:groups": [
    "ROLE_ADMIN"
  ],
  "iss": "https://cognito-idp.eu-west-1.amazonaws.com/eu-west-1_mt1mX8KOM",
  "client_id": "qnfqphkeq96ppijrcndm2kjnm",
  "origin_jti": "67b626d7-a6dd-425e-82e1-45e34478cb55",
  "event_id": "3c638d7e-9a9b-4e39-a975-919cb8b97686",
  "token_use": "access",
  "scope": "aws.cognito.signin.user.admin",
  "auth_time": 1675267259,
  "exp": 1675267559,
  "iat": 1675267259,
  "jti": "57834560-765f-45a3-bde3-2f0afe665a1f",
  "username": "toregard1"
}
```

VERIFY SIGNATURE:
```json

RSASHA256(
  base64UrlEncode(header) + "." +
  base64UrlEncode(payload),
  
{
  "e": "AQAB",
  "kty": "RSA",
  "n": "rjyLqgyu2SOEGKqifOXsYD4VaKelf2MtjQe04EzGTvFMeo_QyCXxfhYDuajPczT4dkmicFNQQpWP6NQgIGRDleoJ7BFptEddAPdFVtXWjZQpO0y6jezSrbkRk9w8lNvZFkFb13kmjwrcJMKdwQcx_T15f6XickWO0tB3Tmmr68rPZP9L9TeW8k_8tMhhS0pukWOhkpz-BDpk1V-9qSk0Lhb0J-j4Ip01c-g_Vni_AX2g0OcNIyNwRuUVE-tAhijt8QR1erKiftlGLikTRpq6ECjiTsQ8dRJ0GgV101F9By74px6HfP_dZBUj30fbn5CxGyhunhXnu4n5cr-zQjJ5Dw"
}
,
  
Private Key in PKCS #8, PKCS #1, or JWK string format. The key never leaves your browser.

)
  
Public Key in SPKI, PKCS #1, X.509 Certificate, or JWK string format.
,
  
Private Key in PKCS #8, PKCS #1, or JWK string format. The key never leaves your browser.

)
```


