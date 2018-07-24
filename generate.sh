#!/bin/sh

OUT=generated

mkdir -p $OUT

for L in ada-server akka-scala android apache2 apex aspnetcore bash csharp clojure cwiki cpprest csharp-dotnet2 dart elixir elm eiffel erlang-client erlang-server finch flash python-flask go go-server groovy haskell-http-client haskell jmeter jaxrs-cxf-client jaxrs-cxf java inflector jaxrs-cxf-cdi jaxrs-spec jaxrs msf4j java-pkmst java-play-framework jaxrs-resteasy-eap jaxrs-resteasy javascript javascript-closure-angular java-vertx kotlin lua lumen nancyfx nodejs-server objc perl php powershell pistache-server python qt5cpp r rails5 restbed ruby rust rust-server scala scala-lagom-server scalatra scalaz php-silex sinatra slim spring dynamic-html html2 html swagger swagger-yaml swift4 swift3 swift php-symfony tizen typescript-aurelia typescript-angular typescript-angularjs typescript-fetch typescript-jquery typescript-node undertow ze-ph
do
    swagger-codegen generate -i swagger.yaml -l $L -o $OUT/$L
done
