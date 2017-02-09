
# Mall Config Server

1. create a specific directory in your OS.
```
mkdir -p $HOME/.millimall/config-server-files
```
2. Copy these configuration files to this directory

```
cp config-server-files/* $HOME/.millimall/config-server-files
```

3. Start server
```
mvn spring-boot:run
```