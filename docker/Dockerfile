FROM circleci/openjdk:8-jdk-node-browsers

ENV LOCAL_JMX=no
ENV NODES_PER_DC=2
ENV CASSANDRA_VERSION=2.1.20

RUN sudo apt-get update -qq; \
    sudo apt-get install -y libjna-java python-dev python-pip libyaml-dev nodejs; \
    sudo pip install pyYaml ccm; \
    sudo npm install -g bower > /dev/null

WORKDIR /home/circleci/
ADD pom.xml .
ADD src src

RUN  mvn -B dependency:go-offline; \
     ccm create test_2_1 --no-switch -v 2.1.20; \
     ccm create test_2_2 --no-switch -v 2.2.13; \
     ccm create test_3_0 --no-switch -v 3.0.17; \
     ccm create test_3_11 --no-switch -v 3.11.3;
     # 4.0 builds are ignored until new ccm version is released and available in pip
     #   see comment below under "workflows"
     #ccm create test_trunk --no-switch -v git:trunk

ADD docker/docker-entrypoint.sh .
RUN sudo chmod +x /home/circleci/docker-entrypoint.sh

ENTRYPOINT ["./docker-entrypoint.sh"]