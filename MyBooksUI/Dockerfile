FROM node:10.16.3
RUN mkdir -p /usr/src/app
WORKDIR /usr/src/app
COPY package.json /usr/src/app
RUN npm install -g @angular/cli @angular-devkit/build-angular && npm install
COPY . /usr/src/app
EXPOSE 4200
CMD ["npm", "start"]



