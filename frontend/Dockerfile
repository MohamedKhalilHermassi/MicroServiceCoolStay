
FROM node:latest as build

WORKDIR /usr/local/app

COPY ./ /usr/local/app/

RUN npm install

RUN npm run build

FROM nginx:latest

EXPOSE 4200

COPY --from=build /usr/local/app/dist/frontend /usr/share/nginx/html

CMD ["nginx", "-g", "daemon off;"]
