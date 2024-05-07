Dans notre projet, on a implémenté un service P2P pour le partage des fichiers, le but est de rendre disponible quelques fichiers que les autres pairs puissent le télécharger et voir son contenu.



Comment utiliser l'application ?

Lancement et mise en place : 
- À l'intérieur de fichier zip vous aller trouver un dossier "P2P_distributed-programming-in-java"
- Dézipper le fichier et vous déplacez le dossier dans NetBeansProjects.
- l'IDE pour ce projet est Netbeans 21.



La compilation est l'exécution : 
+ Démarrez l'IDE et ouvrir le projet « P2P_distributed-programming-in-java » vous trouverais 2  packages : modules et package_main.
+ compiler les classes dans le package modules : PairConnu.java, Progression.java,RechercheFichier.java
+ puis compiler la classe Main.java qui se trouve dans le package package_main.
+ la classe Main.java est la classe principale pour l'interface graphique et les différents managements de Pair.
+ lancer l’exécution de la classe Main.java


Utiliser de l'interface graphique :

Après l'exécution vous verrais une interface graphique simple qui contient des champs nécessaires pour l'interaction entres les pairs.

Pour le numéro, port du c'est IP:127.0.0.1 qui est localhost, avec des valeurs entre 1000 et 2000.
Une fois le serveur connecté au port, on aura la liste des clients qui sont disponibles pour l’interaction.
Pour chaque client ou serveur choisi, on a le choix de lui demander 6 informations :
- Name ? : pour chaque client qui a reçu ce message, il va renvoyer son pseudonyme.
- Known peers ? : client ou serveur renvois la liste des paires qu’il connaît déjà.
- it’s me : quand un client (paire) reçoit ce message, il ajoute l’expéditeur du message à sa liste « known peers » à l’aide de l’adresse IP et le port envoyé avec ce message.
- File ? : le pair qui reçoit ce message, il va recevoir un String et un entier, pour rechercher le String qui matche un nom de fichier existant.
- Voilà ! : ce message notifie à un pair les fichiers qui correspondent à une requête donnée.
-download : un pair qui reçoit ce message doit renvoyer le contenu du fichier demandé au pair expéditeur du message.
- bye : ce message est envoyé pour notifier que le pair est déconnecté du réseau.

