# Commandes GIT utilisées 

## <u>Configurations globales</u>

<b>Changer le nom de l'utilisateur : </b>`git config --global user.name *nom de l'utilisateur*` 

<b>Changer le mail de l'utilisateur : </b> `git config --global user.email *email*`

## <u>Relier un dépôt local et un dépôt distant</u>

<b>Créer le lien entre les dépôts : </b>`git remote add origin *lien  du dépôt distant*`

<b>Changement du nom de la branche principale en "main" : </b>`git branch -M main`

<b>Cloner le dépôt distant en local : </b>`git clone *url du dépôt distant*`

## <u>Cycle d'ajout/suppression de fichiers sur les dépôts</u>

<b>Récupérer la version actuelle du dépôt distant (dans le repository) : </b>`git pull`

<b>Indexer un fichier à ajouter/modifier (l'ajouter du working directory vers l'index/stage) : </b>`git add *nom du fichier*`

<b>Indexer un fichier à supprimer : </b>`git rm *nom du fichier* `

<b>Création d'une nouvelle version sur le dépôt local avec les fichiers indexés : </b>`git commit -m *message de version*`

<b>Envoi de la version actuelle du dépôt local vers le dépôt distant : </b>`git push`

## <u>Travail sur les branches</u>

<b>Visualiser les branches :</b>`git branch`

<b>Créer une nouvelle branche : </b>`git branch *nom de la branche*`

<b>Changer de branche courante : </b>`git checkout *nom de la branche*`

<b>Importer la branche dans le dépôt distant : </b>`git push -u origin *nom de la branche*`

<b>Pour fusionner une branche avec la branche principale : </b>`git merge *nom de la branche*`(:warning:: il faut se placer dans la branche principale auparavant)

<b>Pour supprimer une branche : </b>`git branche -d *nom de la branche`

## <u>Correction des fichiers indexés avant commit</u>

<b>Pour effectuer une remise (stocker les fichiers indexés pour une autre branche) : </b>`git stash`

<b>Pour appliquer la dernière remise sur la branche courante : </b>`git stash apply`

<b>Pour afficher la liste de toutes les remises : </b>`git stash list`

<b>Pour appliquer une remise quelconque : </b>`git stash apply *identifiant de la remise*`

## <u>Gestion des commit</u>

<b>Pour analyser les derniers commit : </b>`git log`

<b>Pour reset un commit sur la mauvaise branche : </b>

​	`git reset --hard HEAD^`(pour supprimer du main le dernier commit)

​	`git checkout *nom de la branche*`(pour revenir sur la bonne branche)

​	`git reset --hard *8premiers caractères du HASH du commit*`(pour appliquer le commit sur la bonne branche)

<b>Pour modifier le message du dernier commit : </b>`git commit --amend -m *nouveau message*`

<b> Pour ajouter un fichier à un commit déjà fait : </b>

​	`git add *nom du fichier `(permet de l'indexer)

​	`git commit --amend --no-edit`(permet d'ajouter les fichiers indexés au dernier commit sans modifier le message)

## <u>Annulation des commit réalisés</u> 

<b> Pour annuler les changements commités (:warning:Pour les commit publiques) : </b>`git revert`(cela crée un commit reprenant la version précédente)

<b>Pour annuler les changements non commités(:warning:Pour les commit privés) : </b>`git reset HEAD^`(ne crée pas de commit)

## <u>Types de Réinitialisation de Git</u>

`git reset --hard `<b> : Supprime tout (working depository, stage, repository)</b>

`git reset --mixed ` <b>: (reset par défaut) Permet de revenir au dernier commit sans toucher aux fichiers en cours de modification (supprime donc le stage, repository) </b>

`git reset --soft`<b> : Permet de se placer à un commit spécifique ou de créer une branche partant d'un ancien commit (modifie juste le repository)</b>

## <u>Actions de vérification Git</u> 

<b>Pour énumérer toutes les actions réalisées : </b>`git reflog`

<b>Pour revenir à une action donnée : </b>`git checkout *ID SHA-1 de l'action*`

<b>Pour analyser le contenu ligne par ligne d'un fichier : </b>`git blame *nom du fichier*`

<b>(:warning:Déconseillé) Pour fusionner un ancien commit d'une branche au master : </b>`git cherry-pick *nom du commit*`









