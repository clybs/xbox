# xbox
It's an x in a box

### Compile the app
Go to project folder and type:

```sh
$ cd xbox/src
$ mkdir tmp
$ javac -d tmp xbox/*.java
```

### Run the app
Go to project folder and type:

```sh
$ cd xbox/src/tmp
$ java xbox.Xbox
```

### Create a jar file and run the app
Go to project folder and type:

```sh
$ cd xbox/src/tmp
$ jar -cfev xbox.jar xbox.Xbox xbox
$ java -jar xbox.jar
```

Play with the xBox:
Available actions:
- 0  - Quit
- 1  - Print a list of available actions
- 2  - Set box height (Minimum of 3)
- 3  - Set box width (Minimum of 3)
- 4  - Set box top and bottom borders
- 5  - Set box left and right borders
- 6  - Move cursor left
- 7  - Move cursor right
- 8  - Move cursor up
- 9  - Move cursor down
- 10  - Set borderless on
- 11  - Set borderless off
- 12  - Display box

Choose your action:
```java
-------
|X    |
|     |
|     |
|     |
|     |
-------
```
