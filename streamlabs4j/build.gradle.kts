// In this section you declare the dependencies for your production and test code
dependencies {
	// HTTP Client
	api(group = "io.github.openfeign", name = "feign-slf4j")
	api(group = "io.github.openfeign", name = "feign-okhttp")
	api(group = "io.github.openfeign", name = "feign-jackson")
	api(group = "io.github.openfeign", name = "feign-hystrix")

	// CredentialManager
	api(group = "com.github.philippheuer.credentialmanager", name = "credentialmanager")
	testImplementation(group = "com.github.PhilippHeuer", name = "credential-manager-ews")

	// Jackson (JSON)
	api(group = "com.fasterxml.jackson.core", name = "jackson-databind")
	api(group = "com.fasterxml.jackson.core", name = "jackson-annotations")
	api(group = "com.fasterxml.jackson.datatype", name = "jackson-datatype-jsr310")
	api(group = "com.fasterxml.jackson.datatype", name = "jackson-datatype-jdk8")
}

publishing.publications.withType<MavenPublication> {
	artifactId = "streamlabs4j"
	pom {
		name.set("Streamlabs4J")
		description.set("Streamlabs4J")
	}
}
