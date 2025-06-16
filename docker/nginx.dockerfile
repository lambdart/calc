FROM nginx:alpine

COPY docker/nginx.conf /etc/nginx/nginx.conf

COPY --from=calc-calc:latest /app/resources/public /usr/share/nginx/html
