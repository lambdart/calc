FROM clojure:temurin-24-tools-deps-alpine

# Install dependencies
RUN apk add --no-cache -u rlwrap && \
    rm -rf /var/cache/apk/*

# create default app directory
RUN mkdir /app

# copy project
COPY . /app

# change working directory
WORKDIR /app

# install deps
RUN clj -P
