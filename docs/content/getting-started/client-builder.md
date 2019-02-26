+++
title="Client-Builder"
weight = 5
+++

# Streamlabs4J Client Builder

## All Features
Initialize the Streamlabs4J Client using the clientId and clientSecret you got after [registering your app](https://streamlabs.com/dashboard#/apps/register):

```java
StreamlabsApi api = StreamlabsApiBuilder.builder()
        .withClientId("yourClientId")
        .withClientSecret(yourClientSecret)
        .build();
```

You can now interract with the api using the obect you have just created !
