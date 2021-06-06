![The demo illustration](https://github.com/arih1299/demo-eda/blob/master/flow.png "The demo illustration")

To run the apps
```
docker compose -f docker-compose-eda.yml up
```

To run the tests, use the following sample command.
--vus = virtual users
--duration = seconds test duration.
```
k6 run --vus 1 --duration 60s load.ts
```