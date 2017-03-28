# Système d’information d’une banque en ligne#

ESIGELEC 2016-2017 Projet S8 TIC

Banque en ligne

Groupe4

### Contexte ###

L’ESIGELEC a été contactée par la DSI d’une banque classique qui souhaite se moderniser en offrant des services en ligne pour :

* améliorer le taux de satisfaction des clients,
* devenir attractive auprès des jeunes générations adeptes des offres digitales.

L’objectif est donc de créer un système d’information complet permettant aux clients ainsi qu’aux salariés de l’entreprise de gérer l’ensemble des comptes, transactions et produits financiers.

### Descriptif du projet ###

L’outil sera utilisé par les acteurs suivants :

* Des visiteurs
* Des clients
* Des conseillers front office
* Des managers

Les visiteurs devront être capables, via un client léger, de :

* consulter les offres de service de la banque
* lire les actualités de la banque
* demander des informations via le formulaire de contact
* créer un compte bancaire
* créer un compte épargne (livret A)
* créer un compte titre
* consulter les cours de la bourse

Les clients devront en plus être capables, via un client léger, de :

* visualiser et modifier leurs informations personnelles
* consulter le solde et l’historique des transactions de leurs comptes
* faire une extraction des relevés de compte(s) au format .csv
* effectuer un virement (interne ou externe)
* alimenter un compte
* acheter et vendre des actions du CAC40

Les conseillers front office devront être capables, via un client lourd, de :

* voir la liste des clients
* consulter les informations personnelles des clients
* consulter le solde et l’historique des transactions de tous les comptes des clients

Les managers devront être capables, via un client léger, de :

* Consulter la somme des dépôts des clients
* Générer des reportings sur les activités des clients

Le moteur de simulation permettra de simuler des actions et des cours de bourses pseudo aléatoires.

### Architecture souhaitée ###

![Architecture](/Conception/architecture.jpg)

### Contraintes du client ###

Le projet devra être réalisé en utilisant la méthodologie Agile Scrum

Le système de gestion de base de données utilisé devra être MySQL

Le langage utilisé sera :

* Java SE pour les clients lourds le serveur des conseillers
* Java EE sur les web containers

### Livrables ###

Documents de conception

Code SQL de la Base de données

Code source et javadoc des applications JEE (sur les 2 serveurs)

Code source et documentation du moteur de simulation

Code source et javadoc du client lourd (conseiller front office)

Le protocole réseau utilisé par le serveur des conseillers (à définir)

### Objectifs pédagogiques ###
A l’issue de ce projet, les élèves devraient être capables de :

· Analyser et comprendre le besoin d’un client en respectant les contraintes (langages,
architecture…)

* Nommer et décrire les différents rôles d’un projet SCRUM
* Appliquer et comprendre la méthodologie agile SCRUM dans un projet
* Concevoir et mettre en place une base de données MySQL correspondant au besoin
* Définir un protocole réseau basé sur TCP/IP
* Mettre en place un serveur Tomcat
* Concevoir et mettre en place une application JEE
* Concevoir et mettre en place une application Java SE qui se connecte à une base de données
* Générer des graphiques pour afficher des statistiques
* Générer des fichiers d’exports à partir de données des clients