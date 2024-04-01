FROM debian

RUN apt -y update
RUN apt -y upgrade
RUN apt install -y htop
RUN apt install -y net-tools
RUN apt install -y ssh
RUN apt install -y mc
RUN apt install -y git
RUN apt install -y openjdk-17-jdk
RUN apt install -y maven


ARG configuration_uri_arg
ARG database_username_arg
ARG database_password_arg

ENV configuration_uri=$configuration_uri_arg
ENV database_username=$database_username_arg
ENV database_password=$database_password_arg

##creamos directorio data que va a tener la aplicacion
RUN mkdir /data
WORKDIR /data

RUN git clone https://github.com/Bautistadev/MicroService_shopping-Service.git

ENTRYPOINT ["/bin/bash"]