### 1. Publish your image in git
```
./gradlew bootBuildImage \
--imageName ghcr.io/lvm3632/gh-actions-spring_catalog-service \
--publishImage \
-PregistryUrl=ghcr.io \
-PregistryUsername=<user_id> \
-PregistryToken=<your_token>
```

### 2. Add this configuration to build.gradle
```
bootBuildImage {
	builder = "docker.io/paketobuildpacks/builder-jammy-base"
	imageName = "${project.name}"
	environment = ["BP_JVM_VERSION": "17"]

	docker {
		publishRegistry {
			username = project.findProperty("registryUsername")
			password = project.findProperty("registryToken")
			url = project.findProperty("registryUrl")
		}
	}
}
```
Buildpacks automatizan la creación de imágenes Docker, evitando que tengas que crear manualmente un Dockerfile.