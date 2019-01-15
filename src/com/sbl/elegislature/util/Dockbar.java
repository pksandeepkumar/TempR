/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sbl.elegislature.util;

import javafx.animation.Animation;
import javafx.animation.Transition;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.util.Duration;

/**
 *
 * @author bipin
 */
public class Dockbar extends VBox {

    private final Button controlButton;
    final Animation hideSidebar, showSidebar;

    public Button getControlButton() {
        return controlButton;
    }

    /**
     * creates a sidebar containing a vertical alignment of the given nodes
     *
     * @param expandedWidth
     * @param nodes
     */
    public Dockbar(final double expandedWidth, Node... nodes) {
        getStyleClass().add("sidebar");
        this.setPrefWidth(expandedWidth);
        this.setMinWidth(0);
        // create a bar to hide and show.
        setAlignment(Pos.CENTER);
        getChildren().addAll(nodes);

        hideSidebar = new Transition() {
            {
                setCycleDuration(Duration.millis(250));
            }

            protected void interpolate(double frac) {
                final double curWidth = expandedWidth * (1.0 - frac);
                setPrefWidth(curWidth);
                setTranslateX(-expandedWidth + curWidth);
            }
        };
        hideSidebar.onFinishedProperty().set(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                setVisible(false);
                controlButton.setText("");
                controlButton.getStyleClass().remove("hide-left");
                controlButton.getStyleClass().add("show-right");
            }
        });

        // create an animation to show a sidebar.
        showSidebar = new Transition() {
            {
                setCycleDuration(Duration.millis(250));
            }

            protected void interpolate(double frac) {
                final double curWidth = expandedWidth * frac;
                setPrefWidth(curWidth);
                setTranslateX(-expandedWidth + curWidth);
            }
        };
        showSidebar.onFinishedProperty().set(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                controlButton.setText("");
                controlButton.getStyleClass().add("hide-left");
                controlButton.getStyleClass().remove("show-right");
            }
        });

        controlButton = new Button("");
        controlButton.setMaxWidth(26);
        controlButton.setMinWidth(26);
        controlButton.getStyleClass().add("hide-left");
        controlButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                // create an animation to hide sidebar.
                if (showSidebar.statusProperty().get() == Animation.Status.STOPPED && hideSidebar.statusProperty().get() == Animation.Status.STOPPED) {
                    if (isVisible()) {
                        hideSidebar.play();
                    } else {
                        setVisible(true);
                        showSidebar.play();
                    }
                }
            }
        });
    }

    public void hide() {
        if(isVisible())
            hideSidebar.play();
    }

    public void show() {
        if(!isVisible())
            showSidebar.play();
    }
}
