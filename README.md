### Install dependencies

#### Quick-start 

```sh
  git submodule update --init --recursive
```

With Node.js installed, run the following from the root of your poly-doh directory:

```sh
cd poly-doh
npm install -g gulp bower && npm install && bower install
gulp --android # Copies a new dist into App's assets (Must be in poly-doh directory)
```

