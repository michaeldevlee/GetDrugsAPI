FROM node:alpine as build

WORKDIR /usr/src/app

COPY . /usr/src/app

RUN npm ci

RUN npm install -g @angular/cli

RUN npm run build --configuration=production

FROM nginx:alpine
COPY --from=build /usr/src/app/dist/angular-showcase/browser /usr/share/nginx/html/
COPY nginx.conf /etc/nginx/conf.d/default.conf