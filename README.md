# MTRX9

MTRX9 is a simple matrix monitoring tool which uses the notions of streams, chars, and time.
MTRX9 is written in Clojure, and uses Websockets.

The live MTRX9 service is provided by [mtrx9.com](http://www.mtrx9.com) ([@mtrx9](https://twitter.com/mtrx9)).

More sleep lost by [tiredpixel](http://www.tiredpixel.com).


## Externals

There is no database or other store.


## Installation

- [Leiningen](https://github.com/technomancy/leiningen)
  
  Version `2.0.0` specified in `project.clj`, but others will probably work.

- Config
  
  Copy and edit as appropriate:
  
  - `.env.example` => `.env`


## Run-time

- Services are defined in `Procfile`.

- Using [Foreman](http://ddollar.github.io/foreman/), `foreman start`.

- Visit the homepage, and click `CREATE`.

- POST data to the matrix. e.g.
  
        $ curl \
          "http://localhost:5000/matrices/T9-32F2-751A-L9-0S2562811624F035L60404LS5A" \
          -d 'streams[a]=1&streams[É]=д'


## Testing

There are no tests. (Yet?)


## Contributions

Contributions are embraced with much love and affection.
Please fork the repository and wizard your magic, ensuring that any tests are not broken by the changes.
Then send a pull request. Simples!
If you'd like to discuss what you're doing or planning to do, or if you get stuck on something, then just wave. :)

Do whatever makes you happy. We'll probably still like you. :)


## Blessing

May you find peace, and help others to do likewise.


## License

© [tiredpixel](http://www.tiredpixel.com) 2013.
It is free software, released under the MIT License, and may be redistributed under the terms specified in `LICENSE`.
