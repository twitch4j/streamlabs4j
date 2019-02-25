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
    maven { url "https://oss.jfrog.org/artifactory/libs-snapshot"}
}
```

```groovy
dependencies {
    compile 'com.github.twitch4j:streamlabs4j:1.0.0-alpha.1-SNAPSHOT'
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
    <repository>
      <id>jcenter-snapshot</id>
      <url>https://oss.jfrog.org/artifactory/libs-snapshot/</url>
    </repository>
</repositories>
```

```xml
<dependency>
    <groupId>com.github.twitch4j</groupId>
    <artifactId>streamlabs4j</artifactId>
    <version>1.0.0-alpha.1-SNAPSHOT</version>
</dependency>
```
