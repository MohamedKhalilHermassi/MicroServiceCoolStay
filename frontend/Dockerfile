FROM node:latest as build

WORKDIR /usr/local/app

COPY ./ /usr/local/app/

RUN npm install

RUN npm run build

FROM nginx:latest

# Expose port 80, which is the default for Nginx
EXPOSE 80

# Copy the built artifacts to the Nginx default HTML directory
COPY --from=build /usr/local/app/dist/frontend /usr/share/nginx/html

# Nginx runs on port 80 by default, so no need to explicitly expose 4200 here

# Start Nginx in the foreground when the container starts
CMD ["nginx", "-g", "daemon off;"]
