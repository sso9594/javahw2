import java.util.Random;

public abstract class GameObject {
    protected int distance;
    protected int x, y;

    public GameObject(int startX, int startY, int distance)	 {
        this.x = startX;
        this.y = startY;
        this.distance = distance;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public boolean collide(GameObject p) {
        if(this.x == p.getX() && this.y == p.getY()) {
            return true;
        } else {
            return false;
        }
    }

    protected abstract void move(int inputX, int inputY);
    protected abstract char getShape();
}

class Bear extends GameObject {

    public Bear(int startX, int startY, int distance) {
        super(startX, startY, distance);
    }

    protected void move(int inputX, int inputY) {
        if(!(getX() == 0 && inputX == -1)) {
            this.x += inputX;
        }
        if(!(getY() == 0 && inputY == -1)) {
            this.y += inputY;
        }
    }

    protected char getShape() {
        return 'B';
    }

}

class Fish extends GameObject {
    Random rand = new Random();
    int randomMove;
    int cnt = 1;

    public Fish(int startX, int startY, int distance) {
        super(startX, startY, distance);
    }

    protected void move(int x, int y) {
        if(cnt < 4) {
            cnt++;
            return;
        } else {
            randomMove = rand.nextInt(4);
            switch(randomMove) {
                case 0 :
                    setX(getX() + 1);
                    break;
                case 1 :
                    setX(getX() - 1);
                    break;
                case 2 :
                    setY(getY() + 1);
                    break;
                case 3 :
                    setY(getY() - 1);
            }
            if(cnt == 5) {
                cnt = 1;
                return;
            }
            cnt++;
        }
    }

    protected char getShape() {
        return '@';
    }

}


