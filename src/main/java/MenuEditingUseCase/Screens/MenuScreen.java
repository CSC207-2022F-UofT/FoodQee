package MenuEditingUseCase.Screens;

//Frameworks & Drivers Layer

import MenuEditingUseCase.MenuEditingController;
import MenuEditingUseCase.MenuEditingPresenter;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.*;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;
import org.bson.types.ObjectId;

public class MenuScreen extends JFrame implements ActionListener{

    MenuEditingController menuEditingController;
    MenuEditingPresenter menuEditingPresenter;

    private static final Color BG_DARK_GREEN =  new Color(38, 73, 65);
    private static final Color BG_LIGHT_GREEN = new Color(87, 118, 83);
    private static final Color HL_LIGHT_GREEN = new Color(166, 199, 148);
    private static final Color HL_ORANGE_YELLOW = new Color(232, 181, 93);
    private static final Color GREY_WHITE = new Color(214, 210, 205);
    private static final Color WHITE = new Color(255, 255, 255);

    private static final Border emptyBorder = BorderFactory.createEmptyBorder(30, 30, 30, 30);
    private static final Border emptyBorder2 = BorderFactory.createEmptyBorder(0, 10, 0, 10);
    private static final Border blackline = BorderFactory.createLineBorder(Color.black);

//    private JPanel menuPanel;

    public MenuScreen(MenuEditingController controller, MenuEditingPresenter presenter){

        this.menuEditingController = controller;
        this.menuEditingPresenter = presenter;
//        this.menuPanel = getMenuPanel();

        final JFrame frame = new JFrame();

        frame.setSize(900, 700);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());
        frame.setLocationRelativeTo(null);

        JPanel resNamePanel = new JPanel();
        JLabel label = new JLabel(controller.getAdd_input().getCurRes().getName());
        label.setFont(new Font("Serif", Font.PLAIN, 40));
        label.setBorder(emptyBorder);
        resNamePanel.add(label);


        JPanel menuPanel = new JPanel();
        menuPanel.setBorder(blackline);
        GridLayout layout = new GridLayout(0, 3);
        layout.setVgap(40);
        layout.setHgap(40);
        menuPanel.setLayout(layout);
        menuPanel.setBorder(emptyBorder);

        JPanel emptyPanel = new JPanel();
        emptyPanel.add(menuPanel);

        JScrollPane menuScroll = new JScrollPane(emptyPanel);
        menuScroll.setBorder(emptyBorder2);
        menuScroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);



        HashMap<String, List> menuDic = controller.getAdd_input().getMenuDic();


        for(int i = 0; i< menuDic.get("name").size(); i++){

            JPanel f = new JPanel();
            f.setBackground(GREY_WHITE);
            f.setLayout(new GridLayout(0, 1));

            JLabel name = new JLabel("Name: " + menuDic.get("name").get(i));
            JLabel price = new JLabel("Price: " + menuDic.get("price").get(i));
            JLabel category = new JLabel("Category: " + menuDic.get("category").get(i));
            JLabel description = new JLabel("Description: " + menuDic.get("description").get(i));
            JButton delete = new JButton("Delete");
            JButton edit = new JButton("Edit");

            name.setBorder(emptyBorder2);
            price.setBorder(emptyBorder2);
            category.setBorder(emptyBorder2);
            description.setBorder(emptyBorder2);

            ObjectId curid = new ObjectId(menuDic.get("id").get(i).toString());

            delete.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent evt) {
                    menuEditingController.create(curid);
                }
            });

            f.add(name);
            f.add(price);
            f.add(category);
            f.add(description);
            f.add(delete);
            f.add(edit);

            menuPanel.add(f);

        }

        JPanel buttonPanel = new JPanel(new GridLayout(0, 2));
        buttonPanel.setBorder(emptyBorder);

        JButton addFoodButton = new JButton("Add Item");
        JButton finishButton = new JButton("Finish");
        JButton refreshButton = new JButton("Refresh");

        addFoodButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AddFoodScreen foodScreen = new AddFoodScreen(controller);
            }
        });

        finishButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
            }
        });

        refreshButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
//                JPanel newMenuPanel = menuEditingPresenter.getMenuPanel();
                emptyPanel.removeAll();
                emptyPanel.add(presenter.getMenuPanel());
                emptyPanel.revalidate();
//                menuScroll.add(newMenuPanel);
//                frame.revalidate();

            }
        });

        buttonPanel.add(addFoodButton);
        buttonPanel.add(finishButton);
        buttonPanel.add(refreshButton);

        frame.getContentPane().add(resNamePanel, BorderLayout.NORTH);
        frame.getContentPane().add(menuScroll, BorderLayout.CENTER);
        frame.getContentPane().add(buttonPanel, BorderLayout.SOUTH);

        frame.setVisible(true);

    }

    public JPanel getMenuPanel(){
        JPanel menuPanel = new JPanel();
        menuPanel.setBorder(blackline);
        GridLayout layout = new GridLayout(0, 3);
        layout.setVgap(40);
        layout.setHgap(40);
        menuPanel.setLayout(layout);
        menuPanel.setBorder(emptyBorder);

        HashMap<String, List> menuDic = menuEditingController.getAdd_input().getMenuDic();


        for(int i = 0; i< menuDic.get("name").size(); i++){

            JPanel f = new JPanel();
            f.setBackground(GREY_WHITE);
            f.setLayout(new GridLayout(0, 1));

            JLabel name = new JLabel("Name: " + menuDic.get("name").get(i));
            JLabel price = new JLabel("Price: " + menuDic.get("price").get(i));
            JLabel category = new JLabel("Category: " + menuDic.get("category").get(i));
            JLabel description = new JLabel("Description: " + menuDic.get("description").get(i));
            JButton delete = new JButton("Delete");
            JButton edit = new JButton("Edit");

            name.setBorder(emptyBorder2);
            price.setBorder(emptyBorder2);
            category.setBorder(emptyBorder2);
            description.setBorder(emptyBorder2);

            f.add(name);
            f.add(price);
            f.add(category);
            f.add(description);
            f.add(delete);
            f.add(edit);

            menuPanel.add(f);

        }
        return menuPanel;
    }
    public void actionPerformed(ActionEvent e){

    }
}
