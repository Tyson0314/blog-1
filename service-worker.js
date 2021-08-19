/**
 * Welcome to your Workbox-powered service worker!
 *
 * You'll need to register this file in your web app and you should
 * disable HTTP caching for this file too.
 * See https://goo.gl/nhQhGp
 *
 * The rest of the code is auto-generated. Please don't update this file
 * directly; instead, make changes to your Workbox build configuration
 * and re-run your build process.
 * See https://goo.gl/2aRDsh
 */

importScripts("https://storage.googleapis.com/workbox-cdn/releases/4.3.1/workbox-sw.js");

self.addEventListener('message', (event) => {
  if (event.data && event.data.type === 'SKIP_WAITING') {
    self.skipWaiting();
  }
});

/**
 * The workboxSW.precacheAndRoute() method efficiently caches and responds to
 * requests for URLs in the manifest.
 * See https://goo.gl/S9QRab
 */
self.__precacheManifest = [
  {
    "url": "404.html",
    "revision": "e6178aedde11af75918ea8fa2dd41e27"
  },
  {
    "url": "assets/css/0.styles.305e47ad.css",
    "revision": "e86d890c5806c36f24f66b38c13e0d52"
  },
  {
    "url": "assets/img/search.83621669.svg",
    "revision": "83621669651b9a3d4bf64d1a670ad856"
  },
  {
    "url": "assets/js/10.9b2ae407.js",
    "revision": "e081b51efcfe88e83cfafc02c285e00f"
  },
  {
    "url": "assets/js/11.3d4335d6.js",
    "revision": "6ba5f1d98fe1e79ae624e47c5df87781"
  },
  {
    "url": "assets/js/12.1f540a5b.js",
    "revision": "30ecd3bd41dfc7d3d4df8a22480f58aa"
  },
  {
    "url": "assets/js/13.83fe607b.js",
    "revision": "01dda93f5c10e9e1ee6fcafa5367b435"
  },
  {
    "url": "assets/js/14.ac6b9897.js",
    "revision": "79c0403f423e99833b8e66e9d7169832"
  },
  {
    "url": "assets/js/15.7f165714.js",
    "revision": "9221dfc1ec1a3bbba6d224a41146c79b"
  },
  {
    "url": "assets/js/16.bd19e412.js",
    "revision": "f5c048d9682ee088b956744730491641"
  },
  {
    "url": "assets/js/17.712c7edd.js",
    "revision": "7545aa6c513a4cce9e86ea33bc100e14"
  },
  {
    "url": "assets/js/18.4738593c.js",
    "revision": "e75914318d45d6af125760710e53c2bd"
  },
  {
    "url": "assets/js/4.d59f4fc8.js",
    "revision": "1422861e8b1862ebb348a69c45e2e86a"
  },
  {
    "url": "assets/js/5.c57c3a10.js",
    "revision": "f1ddf45fc1905fe90c78a903e6747aa5"
  },
  {
    "url": "assets/js/6.139dccb9.js",
    "revision": "1478b880a8698b4b78c905589c80f8dd"
  },
  {
    "url": "assets/js/7.afd745b9.js",
    "revision": "748214941e8c74c14520fd710d27780c"
  },
  {
    "url": "assets/js/8.a0081c7e.js",
    "revision": "434e440991dab1c915605af2d4c5eccb"
  },
  {
    "url": "assets/js/9.2e5f72b7.js",
    "revision": "d1badb7fe1a8ba916d6e95fb42b8016f"
  },
  {
    "url": "assets/js/app.9771b84a.js",
    "revision": "821fdf83beb2696ea160aeb09a8fd3a0"
  },
  {
    "url": "assets/js/vendors~flowchart.292f02c3.js",
    "revision": "c15614723b75f5e0dca5b99264255fd0"
  },
  {
    "url": "assets/js/vendors~notification.4fd649ec.js",
    "revision": "8e0b66833ae16638de1bbe805fea7460"
  },
  {
    "url": "images/javaTKBJ-1.jpeg",
    "revision": "fbead4ad1ef7e7232d78fd94b52c8313"
  },
  {
    "url": "index.html",
    "revision": "96919f840cf09830c5ac57484bb202af"
  },
  {
    "url": "mysql/index.html",
    "revision": "0971e223080eb21d1fc6cef7874307b3"
  },
  {
    "url": "mysql/mysql-index-1.html",
    "revision": "4fbdd725f1b92672f1395a6f0d66e083"
  },
  {
    "url": "mysql/mysql-index-2.html",
    "revision": "5bca6d723d8259b537e207eb58770d58"
  },
  {
    "url": "mysql/mysql-index-3.html",
    "revision": "826b23942f7931a95b2b4eb9d180f3ee"
  },
  {
    "url": "test/experiment-md.html",
    "revision": "4640717efb4f5069cb68af2633c2cb8b"
  },
  {
    "url": "test/index.html",
    "revision": "3837a94e162d0af404f5758f55db3d68"
  },
  {
    "url": "test/jmh-tutorial.html",
    "revision": "3041d090f79724c0d340680986bc5757"
  }
].concat(self.__precacheManifest || []);
workbox.precaching.precacheAndRoute(self.__precacheManifest, {});
addEventListener('message', event => {
  const replyPort = event.ports[0]
  const message = event.data
  if (replyPort && message && message.type === 'skip-waiting') {
    event.waitUntil(
      self.skipWaiting().then(
        () => replyPort.postMessage({ error: null }),
        error => replyPort.postMessage({ error })
      )
    )
  }
})
