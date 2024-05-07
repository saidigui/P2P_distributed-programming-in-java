# P2P_distributed-programming-in-java
Dans notre projet on a implémenté un service P2P pour le  partage des fichiers, le but est de rendre disponible quelques fichiers que les autres pairs puissent le télécharger et voir son contenu.



Comment utiliser l'application :

Lancement et mise en place : 
    - A l'interieur de fichier zip vous aller trouver un dossier "P2P_distributed-programming-in-java"
    - Dizzeper le fichier et vous déplacez le dossier dans NetBeansProjects.
    - l' IDE pour ce projet c'est Netbeans 21.



La compilation est l'éxecution : 
 + Démarréz l'IDE et ouvrir le projet « P2P_distributed-programming-in-java » vous trouverais 2  packages : modules et package_main.
 + compiler les les classes dans le package modules :  PairConnu.java, Progression.java,RechercheFichier.java
 + puis compiler la classe Main.java  qui se trouve  dans le package package_main.
 + la class Main.java est la classe principale pour l'interface graphique et les differentes managements de Pair.
 + lancer l’exécution de la class Main.java


Utiliser de l'interface graphique :

Apres l'éxecution vous verrais une interface graphique simple qui contient des champs nécessaire pour l'interaction entres les pairs.

pour le numero port du c'est IP: 127.0.0.1 qui est  localhost, avec des valeurs entre 1000 et 2000.
Une fois le serveur connecté au port, on aura la liste des clients qui sont disponible pour l’interaction.
Pour chaque client ou serveur choisi, on a le choix de lui demander 6 informations :
-Name ? : Pour chaque client qui a reçu ce message, il va renvoyer son pseudonyme.
-Known peers ? : Client ou serveur renvois la liste des paires qu’il connaît déjà.
-it’s me : Quand un client (paire) reçois ce message, il ajoute l’expéditeur du message à sa liste « known peers » à l’aide de l’adresse IP et le port envoyé avec ce message.
-File ? : Le pair qui reçoit ce message, il va recevoir un String et un entier,  pour rechercher le String qui matche un nom de fichier existant.
- Voilà ! : Ce message notifie à un pair les fichiers qui correspond à une requête donnée.
-download : Un pair qui reçoit ce message doit renvoyer le contenu du fichier demandé au pair expéditeur du message.
-bye : Ce message est envoyé pour notifié que le pair est déconnecté du réseau.

