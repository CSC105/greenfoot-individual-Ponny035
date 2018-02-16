------------------------------------------------------------------------
This is the project README file. Here, you should describe your project.
Tell the reader (someone who does not know anything about this project)
all he/she needs to know. The comments should usually include at least:
------------------------------------------------------------------------

PROJECT TITLE:
PURPOSE OF PROJECT:
VERSION or DATE:
HOW TO START THIS PROJECT:
AUTHORS: Patipol Saechan
USER INSTRUCTIONS:


Code movement 
```java 
private void checkKeys() {
        int x = getX();
        int y = getY();
        if(Greenfoot.isKeyDown("left")) {
            setLocation(x-2, y);
        }
        if(Greenfoot.isKeyDown("right")) {
            setLocation(x+2, y);
        }
    }
```
