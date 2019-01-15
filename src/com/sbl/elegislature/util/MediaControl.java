/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sbl.elegislature.util;

import javafx.application.Platform;
import javafx.beans.Observable;
import javafx.event.ActionEvent;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaPlayer.Status;
import javafx.scene.media.MediaView;
import javafx.util.Duration;

/**
 *
 * @author bipin
 */
public class MediaControl extends BorderPane {

    private final MediaPlayer mp;
    private final MediaView mediaView;
    private final boolean repeat = false;
    private boolean stopRequested = false;
    private boolean atEndOfMedia = false;
    private Duration duration;
    private final Label playTime = new Label();
    private final Slider volumeSlider = new Slider();
    private final Slider timeSlider = new Slider();

    private final Button playButton = new Button(" ");
    private final Button backButton = new Button(" ");
    private final Button forwardButton = new Button(" ");
    private final Button reloadButton = new Button(" ");

    public MediaControl(final MediaPlayer mp) {
        this.mp = mp;
        setStyle("-fx-background-color: #000000;");
        mediaView = new MediaView(mp);
        mediaView.setFitWidth(350);
        setCenter(mediaView);
        mp.currentTimeProperty().addListener((Observable ov) -> {
            updateValues();
        });

        mp.setOnPlaying(() -> {
            if (stopRequested) {
                mp.pause();
                stopRequested = false;
            } else {
                playButton.getStyleClass().remove(1);
                playButton.getStyleClass().add("pauseButton");
            }
        });

        mp.setOnPaused(() -> {
            playButton.getStyleClass().remove(1);
            playButton.getStyleClass().add("playButton");
        });

        mp.setOnReady(() -> {
            duration = mp.getMedia().getDuration();
            updateValues();
        });

        mp.setCycleCount(repeat ? MediaPlayer.INDEFINITE : 1);
        mp.setOnEndOfMedia(() -> {
            if (!repeat) {
                playButton.getStyleClass().remove(1);
                playButton.getStyleClass().add("playButton");
                stopRequested = true;
                atEndOfMedia = true;
            }
        });
        setBottom(addToolBar());
    }

    private GridPane addToolBar() {
        GridPane toolBar = new GridPane();
        toolBar.setStyle("-fx-background-color: #ffffff");
        toolBar.setPadding(new Insets(5));
        toolBar.setAlignment(Pos.CENTER);
        toolBar.alignmentProperty().isBound();
        toolBar.setHgap(2);
        toolBar.setVgap(2);

        timeSlider.setMinWidth(50);
        timeSlider.setMaxWidth(Double.MAX_VALUE);

        playTime.setPrefWidth(130);
        playTime.setMinWidth(50);

        volumeSlider.valueProperty().addListener((Observable ov) -> {
            if (volumeSlider.isValueChanging()) {
                mp.setVolume(volumeSlider.getValue() / 100.0);
            }
        });
        volumeSlider.setMinWidth(50);
        volumeSlider.setMaxWidth(Double.MAX_VALUE);
        playButton.getStyleClass().add("playButton");
        backButton.getStyleClass().add("rewindButton");
        forwardButton.getStyleClass().add("forwardButton");
        reloadButton.getStyleClass().add("refreshButton");

        toolBar.add(playTime, 0, 0, 4, 1);
        toolBar.add(timeSlider, 3, 0, 6, 1);
        toolBar.add(backButton, 0, 1);
        toolBar.add(playButton, 1, 1);
        toolBar.add(forwardButton, 2, 1);
        toolBar.add(reloadButton, 3, 1);
        toolBar.add(volumeSlider, 4, 1, 4, 1);
        GridPane.setHalignment(volumeSlider, HPos.CENTER);
        toolBar.add(new ImageView(new Image(getClass().getClassLoader()
                .getResource("resources/png/minvolume.png").toExternalForm())), 8, 1);
        playButton.setOnAction((ActionEvent e) -> {
            mp.play();
        });

        playButton.setOnAction((ActionEvent e) -> {
            Status status = mp.getStatus();

            if (status == Status.UNKNOWN || status == Status.HALTED) {
                // don't do anything in these states
                return;
            }

            if (status == Status.PAUSED
                    || status == Status.READY
                    || status == Status.STOPPED) {
                // rewind the movie if we're sitting at the end
                if (atEndOfMedia) {
                    mp.seek(mp.getStartTime());
                    atEndOfMedia = false;
                }
                mp.play();
            } else {
                mp.pause();
            }
        });

        forwardButton.setOnAction((ActionEvent e) -> {
            mp.seek(mp.getCurrentTime().multiply(1.5));
        });

        backButton.setOnAction((ActionEvent e) -> {
            mp.seek(mp.getCurrentTime().divide(1.5));
        });
        reloadButton.setOnAction((ActionEvent e) -> {
            playButton.getStyleClass().remove(1);
            playButton.getStyleClass().add("pauseButton");
            mp.seek(mp.getStartTime());
        });
        timeSlider.valueProperty().addListener((Observable ov) -> {
            if (timeSlider.isValueChanging()) {
                mp.seek(duration.multiply(timeSlider.getValue() / 100.0));
            }
        });

        return toolBar;

    }

    protected void updateValues() {
        if (playTime != null && timeSlider != null && volumeSlider != null) {
            Platform.runLater(() -> {
                Duration currentTime = mp.getCurrentTime();
                playTime.setText(formatTime(currentTime, duration));
                timeSlider.setDisable(duration.isUnknown());
                if (!timeSlider.isDisabled() && duration.greaterThan(Duration.ZERO) && !timeSlider.isValueChanging()) {
                    timeSlider.setValue(currentTime.divide(duration).toMillis() * 100.0);
                }
                if (!volumeSlider.isValueChanging()) {
                    volumeSlider.setValue((int) Math.round(mp.getVolume() * 100));
                }
            });
        }
    }

    private static String formatTime(Duration elapsed, Duration duration) {
        int intElapsed = (int) Math.floor(elapsed.toSeconds());
        int elapsedHours = intElapsed / (60 * 60);
        if (elapsedHours > 0) {
            intElapsed -= elapsedHours * 60 * 60;
        }
        int elapsedMinutes = intElapsed / 60;
        int elapsedSeconds = intElapsed - elapsedHours * 60 * 60
                - elapsedMinutes * 60;

        if (duration.greaterThan(Duration.ZERO)) {
            int intDuration = (int) Math.floor(duration.toSeconds());
            int durationHours = intDuration / (60 * 60);
            if (durationHours > 0) {
                intDuration -= durationHours * 60 * 60;
            }
            int durationMinutes = intDuration / 60;
            int durationSeconds = intDuration - durationHours * 60 * 60
                    - durationMinutes * 60;
            if (durationHours > 0) {
                return String.format("%d:%02d:%02d/%d:%02d:%02d",
                        elapsedHours, elapsedMinutes, elapsedSeconds,
                        durationHours, durationMinutes, durationSeconds);
            } else {
                return String.format("%02d:%02d/%02d:%02d",
                        elapsedMinutes, elapsedSeconds, durationMinutes,
                        durationSeconds);
            }
        } else {
            if (elapsedHours > 0) {
                return String.format("%d:%02d:%02d", elapsedHours,
                        elapsedMinutes, elapsedSeconds);
            } else {
                return String.format("%02d:%02d", elapsedMinutes,
                        elapsedSeconds);
            }
        }
    }
}
