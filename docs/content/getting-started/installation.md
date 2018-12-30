+++
title="Installation"
weight = 2
+++

# Installation

We recommend using a dependency management tool to manage streamlabs4j and sub dependencies.

## Gradle
Add it to your build.gradle with:
```groovy
repositories {
	jcenter()
}
```
and: (latest, you should use the actual version here)

```groovy
dependencies {
    compile 'com.github.twitch4j:streamlabs4j:1.0.0'
}
```

## Maven
Add it to your pom.xml with:
```xml
<repositories>
    <repository>
      <id>jcenter</id>
      <url>https://jcenter.bintray.com/</url>
    </repository>
</repositories>
```
and: (latest, you should use the actual version here)

```xml
<dependency>
    <groupId>com.github.twitch4j</groupId>
    <artifactId>streamlabs4j</artifactId>
    <version>v1.0.0</version>
</dependency>
```
