# <strong style="color:blue; opacity: 0.80">AP-micro-service-with-centralized-configuration-and-consul-discovery-service</strong>:mortar_board::computer: 
# <span style="color:green "> 1.Présentation de l'activité pratique</span>
 * <strong style="color:dark">Créer une application de e-commerce basée sur les micro services :
        1. Consul Discovery
        
        2. Spring Cloud Config
        
        3. Spring Cloud Gateway
        
        4. Customer-service
        
        5. Inventory Service
        
        6. Order Service
        
        7. Consul Config (Billing Service)
        
        8. Vault (Billing Service)
        
        9. Frontend Web avec Angular

</span>
 <span style="color:#66ff66"> Entités et règles de gestion : :label: </span>
 
L’architecture de cette application devra gérer 3 entités. 
    Les entités utilisées dans l’application sont : 
* * * 

>	Une entité "Customer" qui comporte les propriétés suivantes :
 - id
 - email
 - nom

```java
    public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
}

```

>	Une entité "Produit" qui comporte les propriétés suivantes :
 - id
 - quantity
 - nom
 - price

```java
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private double price;
    private int quantity;
}

```

>	Une entité "Order" qui comporte les propriétés suivantes :
 - id
 - liste des produits
 - totalPrice

```java
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date createdAt;
    private OrderStatus status;
    private Long customerId;

    @Transient
    private Customer customer;

    @OneToMany(mappedBy = "order")
    private List<ProductItem> productItems;

    public double getTotal(){
        return productItems.stream()
                .mapToDouble(ProductItem::getTotal).sum();
    }
}
```
# <span style="color:green "> 2.Architecture de l'activité pratique</span>

![](https://i.imgur.com/6jajo4k.png)
___

![](https://i.imgur.com/9G0xYcB.png)


# <span style="color:green "> Le service "customer-service"</span>

![](https://i.imgur.com/JnFyV54.png)

![](https://i.imgur.com/Dly0S6J.png)

![](https://i.imgur.com/LTWJUx3.png)

![](https://i.imgur.com/PGkg2Fe.png)


---
# <span style="color:green "> Le service "inventory-service"</span>

![](https://i.imgur.com/CUuZZQm.png)

![](https://i.imgur.com/K1pwARg.png)

![](https://i.imgur.com/17K9S2o.png)

![](https://i.imgur.com/nQc3An2.png)


---
# <span style="color:green "> Le service "gateway-service"</span>

![](https://i.imgur.com/V2VEwDr.png)


//application
![](https://i.imgur.com/oyvh5iY.png)


![](https://i.imgur.com/tipf9UU.png)

# <span style="color:green "> Le service de discovery "Consul"</span>

![](https://i.imgur.com/0o0Tp6p.png)


# <span style="color:green "> Le service "order-service"</span>

![](https://i.imgur.com/DQ7RoBY.png)


# <span style="color:green "> La configuration avec VAULT</span>

![](https://i.imgur.com/Q5QZR2x.png)

![](https://i.imgur.com/6EWfN5o.png)

![](https://i.imgur.com/QM1azoh.png)
![](https://i.imgur.com/iVX8sK6.png)
![](https://i.imgur.com/JJ5jyo6.png)
![](https://i.imgur.com/GZIX9fd.png)

*aprés la configuration par consul config et vault config

![](https://i.imgur.com/ZPADaoS.png)

# <span style="color:green "> ZipKin + Sleuth </span>

![](https://i.imgur.com/wf2NWpk.png)
---

![](https://i.imgur.com/A3rzrw4.png)
---
![](https://i.imgur.com/uNxbyP7.png)
---
![](https://i.imgur.com/zToOfNO.png)
---


# <span style="color:green "> Frontend avec Angular </span>

![](https://i.imgur.com/Ntqmv5E.png)

> [name=elmajnikhaoula]La liste des produits

![](https://i.imgur.com/9na1dt8.png)

> [name=elmajnikhaoula]La liste des clients

![](https://i.imgur.com/lybwmmH.png)

> [name=elmajnikhaoula]La liste des factures par client

![](https://i.imgur.com/l3hpiQV.png)

> [name=elmajnikhaoula]Les détails d'une facture d'un client

# <span style="color:green">3.Les Technologies utilisées</span>
 #### <span style="color:#0036ad"> 1.Java</span>
 * <strong style="color:dark">* <strong style="color:dark">Java est le langage de choix pour créer des applications à l'aide de code managé qui peut s'exécuter sur des appareils mobiles.

*voir également à propos* [JAVA](https://www.java.com/fr/):link: 


 #### <span style="color:#0036ad"> 2.Spring Data JPA</span>
 * <strong style="color:dark">Spring Data JPA, qui fait partie de la grande famille Spring Data, facilite la mise en œuvre de référentiels basés sur JPA. Ce module traite de la prise en charge améliorée des couches d'accès aux données basées sur JPA. Il facilite la création d'applications alimentées par Spring qui utilisent des technologies d'accès aux données.
    

*voir également à propos de [Spring Data JPA](https://spring.io/projects/spring-data-jpa) :link: 

    
 #### <span style="color:#0036ad"> 3.Spring Cloud Open Feign</span>
 * <strong style="color:dark">Ce projet fournit des intégrations OpenFeign pour les applications Spring Boot via la configuration automatique et la liaison à l'environnement Spring et à d'autres idiomes de modèle de programmation Spring.
    

*voir également à propos de [Spring Cloud Open Feign](https://spring.io/projects/spring-cloud-openfeign) :link: 
    
  #### <span style="color:#0036ad"> 4.Spring Cloud Gateway</span>
 * <strong style="color:dark">Ce projet fournit une bibliothèque pour créer une passerelle API au-dessus de Spring WebFlux. Spring Cloud Gateway vise à fournir un moyen simple mais efficace d'acheminer vers les API et de leur fournir des préoccupations transversales telles que : la sécurité, la surveillance/les métriques et la résilience.
    

*voir également à propos de [Spring Cloud Gateway](https://spring.io/projects/spring-cloud-gateway) :link: 
    

  #### <span style="color:#0036ad"> 5.Swagger Open API</span>
 * <strong style="color:dark">Swagger est une suite d'outils pour les développeurs d'API de SmartBear Software et une ancienne spécification sur laquelle est basée la spécification OpenAPI.
    

*voir également à propos de [Swagger](https://swagger.io/docs/specification/2-0/what-is-swagger/) :link: 
    
  #### <span style="color:#0036ad"> 6.Docker Compose</span>
 * <strong style="color:dark">Compose est un outil permettant de définir et d'exécuter des applications Docker multi-conteneurs. Avec Compose, vous utilisez un fichier YAML pour configurer les services de votre application.
    

*voir également à propos de [Docker Compose](https://docs.docker.com/compose/) :link: 
    
  #### <span style="color:#0036ad"> 7.Consul</span>
 * <strong style="color:dark">Consul est un outil multi-réseaux qui offre une solution de maillage de services complète qui résout les défis de mise en réseau et de sécurité liés à l'exploitation de microservices et d'infrastructures cloud (multi-cloud et cloud hybride). Cette documentation couvre les principaux concepts de Consul, les problèmes qu'il peut résoudre et contient un démarrage rapide pour l'utilisation de Consul.
    

*voir également à propos de [Consul](https://developer.hashicorp.com/consul/docs?host=www.consul.io) :link: 
    
#### <span style="color:#0036ad"> 8.Vault</span>
 * <strong style="color:dark">Vault est un système de gestion des secrets et du chiffrement basé sur l'identité. Cette documentation couvre les principaux concepts de Vault, les problèmes qu'il peut résoudre et contient un démarrage rapide pour l'utilisation de Vault.
    

*voir également à propos de [Vault](https://developer.hashicorp.com/vault/docs) :link: 

#### <span style="color:#0036ad"> 9.Zipkin</span>
 * <strong style="color:dark">Zipkin est un système de traçage distribué. Il permet de collecter les données de synchronisation nécessaires pour résoudre les problèmes de latence dans les architectures de service. Les fonctionnalités incluent à la fois la collecte et la recherche de ces données.
    

*voir également à propos de [Zipkin](https://zipkin.io/) :link: 

#### <span style="color:#0036ad"> 10.Spring Cloud Sleuth</span>
 * <strong style="color:dark">Spring Cloud Sleuth fournit la configuration automatique de Spring Boot pour le traçage distribué.
Sleuth configure tout ce dont vous avez besoin pour commencer. Cela inclut où les données de trace (spans) sont signalées, combien de traces conserver (échantillonnage), si des champs distants (bagages) sont envoyés et quelles bibliothèques sont tracées.
Plus précisément, Spring Cloud Sleuth…
    

*voir également à propos de [Spring Cloud Sleuth](https://spring.io/projects/spring-cloud-sleuth) :link:


#### <span style="color:#0036ad"> 11.Angular</span>
 * <strong style="color:dark">Angular est un cadre de conception d'applications et une plate-forme de développement permettant de créer des applications d'une seule page efficaces et sophistiquées.
    

*voir également à propos de [Angular](https://angular.io/docs) :link:


    
* <strong style="color: dark ; opacity: 0.80">Enfin nous tenons à remercier le seul et unique, notre professeur Mr YOUSFI Mohamed *Docteur & professeur à l'ENSET MEDIA* pour son soutien et son encouragement envers nous, aussi pour nous avoir donné cette opportunité d'améliorer nos compétences et de connaître les nouvelles technologies comme celles qui nous avons travaillé.

*voir également à propos* Mr [YOUSSFI Mohamed](https://www.linkedin.com/in/mohamed-youssfi-3ab0811b/)
</strong>

> Created by :[name=ELMAJNI KHAOULA]
[time=Mon,2022,11,01][color=#EF0101]
>*voir également à propos de moi* [ELMAJNI Khaoula](https://www.linkedin.com/in/khaoula-elmajni/)