package seabattle;

public class View {
    
    private String[][] textView = new String[10][10];
    private String[] names = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j"};
    
    public View() {
        for (int i = 0; i < textView.length; i++) {
            for (int j = 0; j < textView[i].length; j++) {
                textView[i][j] = GameObjectView.EMPTY.getState();
            }
        }
    }
    
    public void printField(Field field) {
        System.out.print("\t");
        for (int i = 0; i < names.length; i++) {
            System.out.print(names[i] + "\t");
        }
        System.out.println();
        for (int i = 0; i < textView.length; i++) {
            System.out.print((i + 1) + "\t");
            for (int j = 0; j < textView[i].length; j++) {
                System.out.print(textView[i][j] + "\t");
            }
            System.out.println();
        }
        System.out.println("\n\n");
    }
    
    public void updateFieldView(Field field) {
        updateShipView(field);
        updateAssistantView(field);
        updateShotsView(field);
    }
    
    public void updateShipView(Field field) {
        for (int i = 0; i < field.ships.size(); i++) {
            Ship ship = field.ships.get(i);
            Coordinate firstCoordinate = ship.getFirstCoordinate();
            //Coordinate secondCoordinate = ship.getSecondCoordinate();
            int length = ship.getLength();
            int direction = ship.getDirection();
            for (int j = 0; j < length; j++) {
                switch (direction) {
                    case 0:
                        textView[firstCoordinate.getY()][firstCoordinate.getX()] = GameObjectView.UNBROKEN.getState();
                        break;
                    case 1:
                        textView[firstCoordinate.getY() - j][firstCoordinate.getX()] =
                                GameObjectView.UNBROKEN.getState();
                        break;
                    case 2:
                        textView[firstCoordinate.getY()][firstCoordinate.getX() + j] =
                                GameObjectView.UNBROKEN.getState();
                        break;
                    case 3:
                        textView[firstCoordinate.getY() + j][firstCoordinate.getX()] =
                                GameObjectView.UNBROKEN.getState();
                        break;
                    case 4:
                        textView[firstCoordinate.getY()][firstCoordinate.getX() - j] =
                                GameObjectView.UNBROKEN.getState();
                        break;
                }
            }
        }
    }
    
    public void updateAssistantView(Field field) {
        for (Assist assist : field.getAssistSet()) {
            textView[assist.getAssistPoint()
                           .getY()][assist.getAssistPoint()
                                          .getX()] = GameObjectView.IMPOSSIBLE.getState();
            
        }
    }
    
    public void updateShotsView(Field field) {
    
    }
    
}
