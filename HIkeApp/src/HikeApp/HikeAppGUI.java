package HikeApp;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HikeAppGUI extends JFrame {
    private TrailGraph trailGraph;
    private SavedHike savedHike;
    private JTextField trailNameField;
    private JTextField startTrailField;
    private JTextField endTrailField;
    private JTextArea resultArea;
    private JTextArea availableHikesArea;
    private JTextArea recentLogsArea;

    public HikeAppGUI() {
        trailGraph = new TrailGraph();
        savedHike = new SavedHike();

        // Set up the frame
        setTitle("Hike App");
        setSize(1000, 500); // Increase window size
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout(10, 10)); // Add more spacing around components

        // Create main panel with BorderLayout for better organization
        JPanel mainPanel = new JPanel(new BorderLayout(10, 10));

        // Left panel for available hikes
        JPanel leftPanel = createLeftPanel();
        mainPanel.add(leftPanel, BorderLayout.WEST);

        // Center panel for trail info, connecting trails, and finding shortest path
        JPanel centerPanel = createCenterPanel();
        mainPanel.add(centerPanel, BorderLayout.CENTER);

        // Right panel for recent logs
        JPanel rightPanel = createRightPanel();
        mainPanel.add(rightPanel, BorderLayout.EAST);

        // Add the main panel and result area to the frame
        add(mainPanel, BorderLayout.CENTER);
        resultArea = new JTextArea(5, 40);
        resultArea.setEditable(false);
        JScrollPane resultScrollPane = new JScrollPane(resultArea);
        add(resultScrollPane, BorderLayout.SOUTH);
    }

    private JPanel createLeftPanel() {
        JPanel leftPanel = new JPanel();
        leftPanel.setLayout(new BorderLayout());

        availableHikesArea = new JTextArea(15, 20);
        availableHikesArea.setEditable(false);
        JScrollPane availableHikesScroll = new JScrollPane(availableHikesArea);
        leftPanel.add(new JLabel("Available Hikes"), BorderLayout.NORTH);
        leftPanel.add(availableHikesScroll, BorderLayout.CENTER);

        return leftPanel;
    }

    private JPanel createCenterPanel() {
        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.anchor = GridBagConstraints.WEST;

        // Add components to center panel with proper spacing
        gbc.gridx = 0;
        gbc.gridy = 0;
        centerPanel.add(new JLabel("Trail Name:"), gbc);

        gbc.gridx = 1;
        gbc.gridy = 0;
        trailNameField = new JTextField(15);
        centerPanel.add(trailNameField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        JButton addTrailButton = new JButton("Add Trail");
        centerPanel.add(addTrailButton, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        centerPanel.add(new JLabel("Start Trail:"), gbc);

        gbc.gridx = 1;
        gbc.gridy = 2;
        startTrailField = new JTextField(15);
        centerPanel.add(startTrailField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        centerPanel.add(new JLabel("End Trail:"), gbc);

        gbc.gridx = 1;
        gbc.gridy = 3;
        endTrailField = new JTextField(15);
        centerPanel.add(endTrailField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = 2;
        JButton connectButton = new JButton("Connect Trails");
        centerPanel.add(connectButton, gbc);

        gbc.gridx = 0;
        gbc.gridy = 5;
        JButton findShortestPathButton = new JButton("Find Shortest Path");
        centerPanel.add(findShortestPathButton, gbc);

        gbc.gridx = 0;
        gbc.gridy = 6;
        JButton saveHikeButton = new JButton("Save Hike");
        centerPanel.add(saveHikeButton, gbc);

        // Action listeners
        addTrailButton.addActionListener(e -> handleAddTrail());
        connectButton.addActionListener(e -> handleConnectTrails());
        findShortestPathButton.addActionListener(e -> handleFindShortestPath());
        saveHikeButton.addActionListener(e -> handleSaveHike());

        return centerPanel;
    }

    private JPanel createRightPanel() {
        JPanel rightPanel = new JPanel();
        rightPanel.setLayout(new BorderLayout());

        recentLogsArea = new JTextArea(15, 20);
        recentLogsArea.setEditable(false);
        JScrollPane recentLogsScroll = new JScrollPane(recentLogsArea);
        rightPanel.add(new JLabel("Recent Hikes"), BorderLayout.NORTH);
        rightPanel.add(recentLogsScroll, BorderLayout.CENTER);

        return rightPanel;
    }

    private void handleAddTrail() {
        String trailName = trailNameField.getText();
        if (!trailName.isEmpty()) {
            Trail newTrail = new Trail(trailName);
            trailGraph.addTrail(newTrail);
            availableHikesArea.append("Trail added: " + trailName + "\n");
            trailNameField.setText(""); // Clear input field
            resultArea.setText("Trail added: " + trailName);
        } else {
            resultArea.setText("Please enter a trail name.");
        }
    }

    private void handleConnectTrails() {
        String startTrailName = startTrailField.getText();
        String endTrailName = endTrailField.getText();

        Trail startTrail = findTrailByName(startTrailName);
        Trail endTrail = findTrailByName(endTrailName);

        if (startTrail != null && endTrail != null) {
            double weight = 1.0; // Default weight
            trailGraph.connectTrails(startTrail, endTrail, weight);
            resultArea.setText("Connected: " + startTrailName + " -> " + endTrailName);
        } else {
            resultArea.setText("Invalid trail names.");
        }

        startTrailField.setText(""); // Clear input field
        endTrailField.setText(""); // Clear input field
    }

    private void handleFindShortestPath() {
        String startTrailName = startTrailField.getText();
        String endTrailName = endTrailField.getText();

        Trail startTrail = findTrailByName(startTrailName);
        Trail endTrail = findTrailByName(endTrailName);

        if (startTrail != null && endTrail != null) {
            String shortestPath = trailGraph.findShortestPath(startTrail, endTrail);
            if (shortestPath != null) {
                resultArea.setText(shortestPath);
            } else {
                resultArea.setText("No path found between " + startTrailName + " and " + endTrailName);
            }
        } else {
            resultArea.setText("Invalid trail names.");
        }

        startTrailField.setText(""); // Clear input field
        endTrailField.setText(""); // Clear input field
    }

    private void handleSaveHike() {
        String trailName = trailNameField.getText();
        if (!trailName.isEmpty()) {
            Trail trail = findTrailByName(trailName);
            if (trail != null) {
                Hike hike = new Hike(trail);
                savedHike.saveHike(hike);
                recentLogsArea.append("Saved hike: " + trailName + "\n");
                resultArea.setText("Hike saved: " + trailName);
            } else {
                resultArea.setText("Invalid trail name. Hike not saved.");
            }
        } else {
            resultArea.setText("Please enter a trail name.");
        }

        trailNameField.setText(""); // Clear input field
    }

    private Trail findTrailByName(String trailName) {
        for (Trail trail : trailGraph.getTrails()) {
            if (trail.getName().equalsIgnoreCase(trailName)) {
                return trail;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new HikeAppGUI().setVisible(true));
    }
}
