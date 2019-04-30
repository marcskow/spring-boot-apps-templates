# spring profiles and docker
Build app jar:
```
gradle build
```

Create and push docker container:
```
docker image build --tag marcskow/profiles:latest .
docker login --username=marcskow
docker push marcskow/profiles
docker image rm marcskow/profiles
```

Run docker container:
```
docker run \
--network=skowrix-net \
-e spring_profiles_active=prod \
-d -p 8195:8195 \
--name skowrix-profiles \
marcskow/profiles:latest
```

Network and postgres should already be created.
