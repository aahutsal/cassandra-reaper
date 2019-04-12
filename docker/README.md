# Building
To build Docker image run that command from root directory. Do to try to run this command from inside `docker` directory, as you will get _docker forbidden path outside the build context_ error!

You can change tag to whatever you wish.
`docker build --tag softsky/cassandra-reaper -f docker/Dockerfile .`

# Running docker container and binding all ports to localhost

To run created docker with all ports bond to localhost invoke the following:

`docker run -ti --rm --network host softsky/cassandra-reaper`

actually `--network host` does the trick
