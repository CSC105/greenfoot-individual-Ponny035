# greenfoot-individual-Ponny035
greenfoot-individual-Ponny035 created by GitHub Classroom

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
