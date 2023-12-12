# Simulación de Pruebas de Rendimiento con Gatling, Maven y Scala

Este repositorio contiene una simulación de pruebas de rendimiento utilizando Gatling, 
Maven y Scala para el sitio web de demostración "demostore.gatling.io". La simulación representa un 
flujo de usuario básico que incluye la navegación por varias páginas, inicio de sesión, navegación por categorías, 
visualización de productos, y el proceso de compra.

## Requisitos

Asegúrate de tener instalados los siguientes componentes antes de ejecutar las pruebas:

- [Gatling](https://gatling.io/docs/current/installation/)
- [Maven](https://maven.apache.org/install.html)
- [Scala](https://www.scala-lang.org/download/)


## Flujo Escenario Compra de Productos en eCommerce

## Descripción
Este escenario simula un flujo de compra típico en un sitio de comercio electrónico utilizando la aplicación de demostración en [https://demostore.gatling.io/](https://demostore.gatling.io/).

## Pasos del Escenario

| Paso | Descripción | Acción |
|------|-------------|--------|
| 1.   | Ingresar a [https://demostore.gatling.io/](https://demostore.gatling.io/) | Acceder a la página de inicio del sitio web de demostración. |
| 2.   | Ingresar a Login | Acceder a la página de inicio de sesión. |
| 3.   | Login con un usuario de la lista: | Iniciar sesión con uno de los usuarios de la lista. <br> - User: john, user1, user2 y user3 <br> - Pass: pass |
| 4.   | Ingresar a la categoría (For Him) | Explorar la categoría "For Him". |
| 5.   | Seleccionar una Gafa - Lente de Sol | Elegir un producto específico en la categoría "For Him". <br> Por ejemplo, seleccionar una Gafa - Lente de Sol. |
| 6.   | Agregar al carro de compra | Agregar el producto seleccionado al carro de compra. |
| 7.   | Ingresar a la categoría (For Her) | Explorar la categoría "For Her". |
| 8.   | Seleccionar una Gafa - Lente de Sol | Elegir un producto específico en la categoría "For Her". <br> Por ejemplo, seleccionar una Gafa - Lente de Sol. |
| 9.   | Agregar al carro de compra | Agregar el producto seleccionado al carro de compra. |
| 10.  | Ingresar al carro de compra | Verificar y revisar el contenido del carro de compra. |
| 11.  | Comprar Productos | Realizar el proceso de compra de los productos en el carro. <br> Confirmar y completar la compra. |


## Configuración

La simulación está configurada para interactuar con el sitio web de demostración "demostore.gatling.io". Puedes ajustar la configuración según tus necesidades modificando el código en `SimulationDemoStoreApp.scala`. En particular, presta atención a la configuración del protocolo HTTP, la URL base y las acciones de la simulación.

```scala
private val httpProtocol = http
  .baseUrl("https://demostore.gatling.io")
  // ... Otras configuraciones ...

private val scn = scenario("SimulationDemoStoreApp")
  // ... Definición de acciones de la simulación ...
  
setUp(scn.inject(atOnceUsers(1))).protocols(httpProtocol)
```

## Instalación

Para instalar las dependencias y ejecutar las pruebas, sigue estos pasos:

1. Clona el repositorio:

```sh
git clone (repo)
cd gatling-demostore-app-curso
```
2. instalar las dependencias

```sh
mvn clean install -U
```
3. Ejecutar tu Simulacion

```sh
mvn gatling:test -Dgatling.simulationClass=demoStoreApp.SimulationDemoStoreApp
```

---

**Firma:** Rodrigo Campos Tapia [@DonTester]

**Sígueme en mis redes sociales:**

[<img src="https://simpleicons.org/icons/instagram.svg" alt="Instagram" width="24"/>](https://www.instagram.com/dontester_/) **Instagram** &nbsp; &nbsp;
[<img src="https://simpleicons.org/icons/twitter.svg" alt="Twitter" width="24"/>](https://twitter.com/DonTester_) **Twitter** &nbsp; &nbsp;
[<img src="https://simpleicons.org/icons/linkedin.svg" alt="LinkedIn" width="24"/>](https://www.linkedin.com/in/rcampostapia) **LinkedIn** &nbsp; &nbsp;
[<img src="https://simpleicons.org/icons/github.svg" alt="GitHub" width="24"/>](https://github.com/rcampos09) **GitHub** &nbsp; &nbsp;
[<img src="https://simpleicons.org/icons/youtube.svg" alt="YouTube" width="24"/>](https://www.youtube.com/@dontester) **YouTube** &nbsp; &nbsp;
[<img src="https://simpleicons.org/icons/medium.svg" alt="Medium" width="24"/>](https://medium.com/@rcampos.tapia) **Medium**



