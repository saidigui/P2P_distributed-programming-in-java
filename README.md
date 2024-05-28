Dans notre projet, nous avons implémenté un service P2P pour le partage de fichiers. Le but est de rendre disponibles certains fichiers afin que les autres pairs puissent les télécharger et en voir le contenu.

Comment utiliser l’application ?

* Lancement et mise en place :

À l’intérieur du fichier zip, vous trouverez un dossier “P2P_distributed-programming-in-java”.
Dézippez le fichier et déplacez le dossier dans NetBeansProjects.
L’IDE pour ce projet est Netbeans 21.


* La compilation et l’exécution :

Démarrez l’IDE et ouvrez le projet « P2P_distributed-programming-in-java ». Vous trouverez 2 packages : modules et package_main.
Compilez les classes dans le package modules : PairConnu.java, Progression.java, RechercheFichier.java.
Puis compilez la classe Main.java qui se trouve dans le package package_main.
La classe Main.java est la classe principale pour l’interface graphique et la gestion des Pairs.
Lancez l’exécution de la classe Main.java.
Utilisation de l’interface graphique :

Après l’exécution, vous verrez une interface graphique simple qui contient les champs nécessaires pour l’interaction entre les pairs.

Pour le numéro de port, utilisez l’IP : 127.0.0.1 qui est localhost, avec des valeurs entre 1000 et 2000. Une fois le serveur connecté au port, vous aurez la liste des clients disponibles pour l’interaction. Pour chaque client ou serveur choisi, vous pouvez demander 6 informations :

Name ? : Chaque client qui reçoit ce message renvoie son pseudonyme.

Known peers ? : Le client ou le serveur renvoie la liste des pairs qu’il connaît déjà.

It’s me : Lorsqu’un client (pair) reçoit ce message, il ajoute l’expéditeur du message à sa liste « known peers » à l’aide de l’adresse IP et du port envoyés avec ce message.

File ? : Le pair qui reçoit ce message va rechercher le String qui correspond à un nom de fichier existant.

Voilà ! : Ce message notifie à un pair les fichiers qui correspondent à une requête donnée.

Download : Un pair qui reçoit ce message doit renvoyer le contenu du fichier demandé au pair expéditeur du message.

Bye : Ce message est envoyé pour notifier que le pair est déconnecté du réseau.

![PEER EXECUTION](https://github.com/saidigui/P2P_distributed-programming-in-java/blob/main/application_en_execution.png)
