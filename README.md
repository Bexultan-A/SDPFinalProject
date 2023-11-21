# SDPFinalProject

UML DIAGRAM:
 ![UML DIAGRAM](UML.png?raw=true)

# IMPLEMENTATIONS OF DESIGN PATTERNS
## Description:
Battle system implemented in which players fight a opponents in turn-based combat. Character classes in the system include mages, rogues, and warriors and each has unique attacks and tactics.The IFightingStrategy interface is used to implement strategies, such as common attacks, special attacks, defense, healing, and mana potions. Adapters are used to balance the general special attack strategy against player-specific attack classes. As the MageDecorator demonstrates, characters may be painted to improve their description and alter attack calculations. The BattleController controls the pace of the combat, giving players the ability to select strategies and opponents the ability to use a variety of tactics. Tower is a feature of the game, and game progress is stored and retrieved using the TowerRepository. The application class is the starting point, from which players can start new games, rejoin ones that are currently being played, and control situations related to game.

## Singleton:
The Singleton pattern is implemented in the PostgresqlDB class that implements IDB interface. IDB interface realizes getconnection() method that uses throw and catch structure. PostgresIDB class can create only 1 instance and connects project to the database. 

## Database: 
The TowerRepository class serves as a bridge between a game's tower and character progression and a PostgreSQL database, encapsulating database operations with clear functionalities. The showEverything method retrieves and displays all data from the "towers" table, while the saveProgress method stores tower progress, including character details, in the same table. The getTowerLevel method retrieves the level of a specific tower, and getCharacter fetches a character associated with a given tower ID, utilizing a character factory and strategy pattern for creation. Additionally, the repository determines character race and class based on description through the getRace and getClass methods.


## Factory:
ICharacter Factory interface declares two methods: createCharacter for creating a basic character, and decorator for applying decorators to a character. The CharacterFactory class implements the IcharacterFactory interface and provides concrete implementations for creating characters and applying decorators based on the provided string.By this methods code generates decorated and wrapped objects by string values 
In the code:
* Creator (IcharacterFactory interface)
*	ConcreteCreator (CharacterFactory class)
*	Product (IСharacter interface)
*	ConcreteProduct (Character class and decorator classes)

## Adapter:
MageAttack, WarriorAttack, RogueAttack: These classes represent existing classes with different interfaces for performing attacks. They are not compatible with the IfightingStrategy interface. IfightingStrategy: This is the desired interface that the client code expects for different fighting strategies. MageAttackAdapter, WarriorAttackAdapter, RogueAttackAdapter: These classes act as adapters between different attacks and ifightingstrategy . 
In the code:
*	Client(chooseStrategy() method)
*	Client Interface(IfightingStrategy)
* Service(MageAttack, WarriorAttack, RogueAttack)
*	Adapter(MageAttackAdapter, WarriorAttackAdapter, RogueAttackAdapter)
Adapter is object adapter.

## Strategy:
IFightingStrategy Interface declares the method PerformAction() and CommonAttackStrategy, DefenceAttackStrategy and etc classes implement  IFightingStrategy interface. These classes changes and boosts attributes of character.  Character class implements ICharacter and consist a lot of attributes like hp,armor,damage and etc that effects to battle system and character behavior.  By changing strategy user uses different attacs in the battle.
In the code:
*	Client(battle application)
*	Context (Character class)
*	Strategy Interface (IFightingStrategy)
*	Concrete Strategies (CommonAttackStrategy, DefenceStrategy, HealPotionStrategy, ManaPotionStrategy, SpecialAttackStrategy)

## Observer:
The provided code implements the Observer Pattern, a behavioral design pattern, where a  Tower maintains a list of observers IAdventurer. When Tower has change (such as reaching a new level), it notifies all registered observers by calling their update method. The observer interface IAdventurer declares this method, ensuring that concrete observer classes can respond appropriately to the notification.
In the code:
*	Publisher(TowerEventManager)
*	Interface Subscriber(IAdventurer)
*	Client(Tower)
*	Concrete subscriber(ICharacter Character)

## Decorator:
Character class represents the basic object being wrapped. Implements the ICharacter interface and provides properties such as name, HP, armor, etc., and methods like calculateAttack, heal, takeDamage, etc. CharacterDecorator implements the ICharacter interface. Contains a field of type ICharacter to reference the wrapped object.  By this code wraps main class character and changes properties of character. MageDecorator, ElfDecorator and etc extend the functionality of the base decorator and override methods and attributes to modify behavior. 
There a lot of decorators but all them could be separated to 2 types: race and class. Race like elf or orc, class like mage,rogue.

## In the code:
*	Client(CharacterFactory)
*	Component(ICharacter)
*	ConcreteComponent(Character)
*	Base Decorator(CharacterDecorator)
*	Concrete Decorators(MageDecorator, ElfDecorator and etc)
