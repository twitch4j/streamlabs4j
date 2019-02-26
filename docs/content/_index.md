+++
title = "Streamlabs4J"
description = ""
+++

# Streamlabs4J

## Overview

* [Getting Started](./getting-started)

## Results of API Calls

This API Client provides you 3 methods to handle / process the results.

### Synchronous Execution

You can execute any api call synchronously with the execute() method, as shown in the following example:

```java
StreamlabsUser user = api.getUser(authToken).execute();
```

### Asynchronous Execution

You can execute any api call asynchronously with the queue() method, as shown in the following example:

```java
Future<StreamlabsUser> userCall = api.getUser(authToken).queue();
```

You can retrieve the result of the command by using the Future:

```java
StreamlabsUser user = userCall.get();
```

### Reactive Execution

You can also observe the results of any api call as an Observable by using one of the following methods:

* observe() — returns a “hot” Observable that executes the command immediately, though because the Observable is filtered through a ReplaySubject you are not in danger of losing any items that it emits before you have a chance to subscribe
* toObservable() — returns a “cold” Observable that won’t execute the command and begin emitting its results until you subscribe to the Observable

```java
Observable<StreamlabsUser> userObservable = api.getUser(authToken).observe();
```

You then retrieve the value of the command by subscribing to the Observable:

```java
userObservable.subscribe(data -> {
    // your code to work with the result data
});
```

## Contribute to this documentation

Feel free to update this content, just edit the files in `docs/content` as usual markdown files and send a pull request.
