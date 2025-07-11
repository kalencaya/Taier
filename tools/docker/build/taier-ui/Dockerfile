FROM nginx:1.21.6 as release

MAINTAINER dazhi <dazhi@dtstack.com>

ENV NODE_HOME=/usr/local/node/node-v16.15.0-linux-x64

ENV PATH=/usr/local/node/node-v16.15.0-linux-x64/bin:/usr/local/sbin:/usr/local/bin:/usr/sbin:/usr/bin:/sbin:/bin

ENV WORK_PATH=/usr/taier
ENV TAIER_IP=localhost
ENV TAIER_PORT=8090
ENV TAIER_UI=$WORK_PATH/ui

WORKDIR $WORK_PATH

RUN /bin/sh -c mkdir /usr/local/node && mkdir $TAIER_UI

ADD https://nodejs.org/dist/v16.15.0/node-v16.15.0-linux-x64.tar.xz /usr/local/node

COPY tools/docker/build/taier-ui/nginx.template /etc/nginx/conf.d/
COPY taier-ui/dist $TAIER_UI/dist

CMD envsubst '$$TAIER_IP $$TAIER_PORT' < /etc/nginx/conf.d/nginx.template > /etc/nginx/conf.d/default.conf \
	&& cat /etc/nginx/conf.d/default.conf \
	&& nginx -g 'daemon off;'