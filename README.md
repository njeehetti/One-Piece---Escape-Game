# ESIEE Java Project · One Piece Escape Game

**[▶ Jouer dans le navigateur](https://njeehetti.github.io/One-Piece---Escape-Game/)** · aucune installation, Java tourne directement dans la page

Jeu d'aventure textuel en Java, de type *Zuul*, réalisé en programmation orientée objet avec BlueJ (ESIEE Paris, 2023-2024).

*A Zuul-style text adventure in Java (BlueJ). Escape the Thousand Sunny before the timer runs out. Playable in the browser. The game is in French.*

![Java 8](https://img.shields.io/badge/Java-8-orange) ![BlueJ](https://img.shields.io/badge/BlueJ-projet%20OOP-blue) ![Swing](https://img.shields.io/badge/GUI-Swing-lightgrey)

---

## Le pitch

L'équipage du Chapeau de Paille reprend la mer après une escale sur l'île scientifique de Vegapunk, quand la Marine attaque. Tu es à bord du **Thousand Sunny** et tu as **15 minutes** pour trouver un moyen de t'échapper.

Explore le navire pièce par pièce, parle aux membres de l'équipage, résous leurs énigmes pour trouver le code du coffre, puis prépare ta fuite. Ton **Dial de Communication** (Den Den Mushi) te guide d'une mission à l'autre.

## Ce qu'il y a dans le jeu

- **14 pièces** du Thousand Sunny : pont supérieur, cuisine, atelier d'Usopp, infirmerie, bar et aquarium, bibliothèque de Robin, salle d'entraînement de Zoro, salle des engins de propulsion…
- **10 membres de l'équipage** à rencontrer, de Luffy à Jimbei, avec chacun son caractère et ses indices.
- **Un compte à rebours de 15 minutes** qui tourne en temps réel.
- **Des énigmes** dont les réponses forment le code du coffre. L'ordre change à chaque partie, et le code est généré aléatoirement.
- **Un inventaire avec une limite de poids**, des objets à lire, à donner ou à utiliser.
- **Des Beamers** (outils du Dr Vegapunk) à charger dans une pièce pour s'y téléporter plus tard.
- **Des pièces de téléportation** qui t'envoient au hasard ailleurs sur le navire.
- **Plusieurs fins** selon la manière dont tu t'échappes… et un lieu secret bien caché.

## Commandes

Tu peux jouer avec les boutons de l'interface ou en tapant des commandes :

| Commande | Effet |
|---|---|
| `start` | Lance la partie et le chrono |
| `go <direction>` | Se déplacer (les boutons affichent les sorties possibles) |
| `back` | Revenir à la pièce précédente |
| `look` | Décrire la pièce et ce qu'elle contient |
| `talk <personnage>` | Parler à un membre de l'équipage |
| `take` / `drop <objet>` | Prendre ou poser un objet |
| `inventory` | Voir son inventaire et sa charge |
| `use` / `give <objet>` | Utiliser un objet ou le donner |
| `charge <beamer>` | Mémoriser la pièce actuelle dans un Beamer |
| `unlock` | Essayer un code sur le coffre |
| `flee` / `launch` | Tenter de s'échapper |
| `help` | Afficher l'aide |
| `quit` | Abandonner (ce n'est pas le but du jeu) |

## Lancer le jeu

**Dans le navigateur** : [njeehetti.github.io/One-Piece---Escape-Game](https://njeehetti.github.io/One-Piece---Escape-Game/). Le premier chargement prend quelques secondes, le temps de démarrer la machine Java.

**En local, avec Java 8 ou plus récent** :

```bash
java -jar one-piece-escape.jar
```

**Dans BlueJ** : extrais `v2.14.zip`, ouvre le projet, puis fais un clic droit sur la classe `Game` et choisis `new Game()`.

## Sous le capot

Le projet part du squelette *World of Zuul* (Barnes & Kölling) et l'étend largement : de 5 classes au départ, on passe à 19.

| Classe | Rôle |
|---|---|
| `GameEngine` | Logique du jeu : création du monde, interprétation des commandes, chrono, fins |
| `UserInterface` | Interface Swing : image de la pièce, journal, boutons de direction et d'actions |
| `Parser`, `Command`, `CommandWords`, `DirectionWords` | Analyse des commandes tapées |
| `Room` → `TransporterRoom` | Pièces et sorties, dont les pièces de téléportation aléatoire |
| `Item` → `Beamer`, `ItemToRead`, `TiempoDial` | Objets avec poids, dont les variantes spéciales |
| `ItemList`, `Player` | Inventaire, charge maximale, historique des déplacements |
| `Character` → `AdvancedCharacter` → `FollowingCharacter` | Personnages, avec dialogues à étapes et compagnon qui te suit (le Dial) |
| `CharacterList` | Gestion des personnages présents dans une pièce |

Concepts mis en œuvre : héritage et polymorphisme, encapsulation, collections (`HashMap`, listes), pile d'historique pour `back`, timers Swing, génération aléatoire, et scripts de test automatisés (`simple.txt`, `normal.txt`, `long.txt`, à jouer avec la commande `test`). La Javadoc est dans `v2.14.zip` (`doc/`, `progdoc/` et `userdoc/`).

## Version web

Le jeu d'origine est une application de bureau Swing. Pour le rendre jouable en ligne sans le réécrire :

- `Launcher.java` ajoute un point d'entrée `main`, puisque BlueJ lance le jeu sans en avoir besoin.
- Les images ont été redimensionnées à leur taille d'affichage, ce qui fait passer le JAR de 25 Mo à 5 Mo.
- `index.html` charge [CheerpJ](https://cheerpj.com/), une machine Java complète compilée en WebAssembly, qui exécute le JAR tel quel. Le site est hébergé par GitHub Pages.

## Crédits

- Conception et développement : **Njee Hettiarachchi**
- Base *World of Zuul* : David J. Barnes et Michael Kölling. Cadre du projet : ESIEE Paris (D. Bureau)
- Java dans le navigateur : [CheerpJ](https://cheerpj.com/) par Leaning Technologies

*Projet de fan réalisé dans un cadre scolaire, sans lien avec Eiichiro Oda, Shueisha ou Toei Animation. One Piece et ses personnages appartiennent à leurs ayants droit.*
