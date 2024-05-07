
package package_main;

import modules.ClientConnu;
import modules.Progression;
import java.awt.Color;
import java.awt.Dimension;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.util.List;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.DatagramSocket;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.file.FileSystems;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Random;
import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public final class Main extends javax.swing.JFrame {

    // parametre globale
    final public static int MIN_PORT = 1000;
    final public static int MAX_PORT = 2000;
    final public static int MAX_LIST_PAIR_CONNUS = 5;

    public static String host, port;
    public SimpleDateFormat date_aff = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
    
    // liste des noms générés.
    List<String> name_generated = Arrays.asList(new String[]{"Dupon", "Marine", "Christopher", "mario", "paul", "alice", "Nathalie", "Celine", "quentin"});
    public List<ClientConnu> liste_pair_connus = new ArrayList();
    
    
    File directory;
    public String dossier_actuel = "";
    public JFileChooser fileChooser = new JFileChooser();
    Progression progress;
    // variable pour la communication
    DataInputStream data_is;
    BufferedReader bf;
    boolean confirmtelechargement = false;
    DefaultListModel<ClientConnu> model = new DefaultListModel<>();

    public Main() {
        initComponents();
        this.setLocationRelativeTo(null);
        initialisation_btn();
        txt_knowed.setModel(model);
        dossier_actuel = FileSystems.getDefault().getPath("").toAbsolutePath().toString();
    }
    public static void envoyer_octets(BufferedInputStream in, DataOutputStream out) throws Exception {
        int count;
        byte[] buffer = new byte[4096];
        while ((count = in.read(buffer)) > 0) {
            out.write(buffer, 0, count);
        }
    }
    public void initialisation_btn(){
        txt_port.getEditor().getComponent(0).setBackground(Color.cyan);
        txt_port.getEditor().getComponent(0).setForeground(new Color(47, 141, 70));
        txt_port.setBorder(BorderFactory.createLineBorder(Color.black));
        Dimension d = new Dimension(txt_port.getWidth(), txt_port.getHeight());
        txt_port.setPreferredSize(d);
        txt_port.setMinimumSize(d);
        btn_search.setEnabled(false);
        txt_dispo.setEnabled(false);
        txt_message.setEnabled(false);
        btn_envoi_message.setEnabled(false);
        txt_envoyer.setEditable(false);
        txt_file_telecharger.setEnabled(false);
        txt_tentation.setEnabled(false);
        txt_filename.setEnabled(false);
        txt_knowed.setEnabled(false);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextField1 = new javax.swing.JTextField();
        btn_connexion = new javax.swing.JButton();
        txt_port = new javax.swing.JSpinner();
        jLabel1 = new javax.swing.JLabel();
        txt_connexion_etat = new javax.swing.JLabel();
        txt_dispo = new javax.swing.JComboBox();
        jLabel2 = new javax.swing.JLabel();
        txt_recherche_client = new javax.swing.JLabel();
        btn_search = new javax.swing.JButton();
        txt_message = new javax.swing.JComboBox();
        btn_envoi_message = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        txt_envoyer = new javax.swing.JTextPane();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txt_filename = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txt_tentation = new javax.swing.JSpinner();
        jLabel7 = new javax.swing.JLabel();
        txt_host = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        txt_file_telecharger = new javax.swing.JComboBox();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        txt_knowed = new javax.swing.JList();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator3 = new javax.swing.JSeparator();

        jTextField1.setText("jTextField1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("PEER");
        setPreferredSize(new java.awt.Dimension(600, 600));
        setResizable(false);

        btn_connexion.setText("Connexion");
        btn_connexion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_connexionActionPerformed(evt);
            }
        });

        txt_port.setFont(new java.awt.Font("Courier New", 1, 11)); // NOI18N
        txt_port.setModel(new javax.swing.SpinnerNumberModel(1000, 1000, 2000, 1));
        txt_port.setValue(1000);

        jLabel1.setText("Etat : ");

        txt_connexion_etat.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        txt_connexion_etat.setText("Déconnecté");

        txt_dispo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "None" }));
        txt_dispo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_dispoActionPerformed(evt);
            }
        });

        jLabel2.setText("Clients disponibles :");

        txt_recherche_client.setText("0");

        btn_search.setText("Actualiser");
        btn_search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_searchActionPerformed(evt);
            }
        });

        txt_message.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Faites votre choix S.V.P", "Name ?", "Known Peer ?", "it's me!", "File!", "Download !", "bye !" }));
        txt_message.setActionCommand("");
        txt_message.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_messageActionPerformed(evt);
            }
        });

        btn_envoi_message.setText("Envoyer");
        btn_envoi_message.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_envoi_messageActionPerformed(evt);
            }
        });

        txt_envoyer.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        txt_envoyer.setName(""); // NOI18N
        jScrollPane1.setViewportView(txt_envoyer);

        jLabel4.setText("Communications:");

        jLabel5.setText("Mes clients connus:");

        jLabel6.setText("Nom du fichier:");

        txt_tentation.setModel(new javax.swing.SpinnerNumberModel(0, 0, 20, 1));
        txt_tentation.setValue(3);

        jLabel7.setText("Nbr Tentation");

        txt_host.setBackground(new java.awt.Color(102, 255, 255));
        txt_host.setFont(new java.awt.Font("Courier New", 1, 11)); // NOI18N
        txt_host.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_host.setText("127.0.0.1");
        txt_host.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_hostActionPerformed(evt);
            }
        });

        jLabel8.setText("Prêt pour le téléchargement");

        jScrollPane4.setViewportView(txt_knowed);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator3)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(520, 520, 520)
                        .addComponent(jSeparator2))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txt_host)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txt_port, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btn_connexion))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txt_connexion_etat, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jScrollPane1)
                                .addContainerGap())))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel8)
                        .addGap(417, 417, 417))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel7))
                                .addGap(27, 27, 27)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txt_filename)
                                    .addComponent(txt_tentation, javax.swing.GroupLayout.PREFERRED_SIZE, 355, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(6, 6, 6))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txt_message, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txt_dispo, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btn_search)
                            .addComponent(btn_envoi_message, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(12, 12, 12))
                    .addComponent(txt_file_telecharger, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jSeparator1)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(txt_recherche_client, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_port, javax.swing.GroupLayout.DEFAULT_SIZE, 23, Short.MAX_VALUE)
                    .addComponent(btn_connexion)
                    .addComponent(txt_host))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txt_connexion_etat))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(3, 3, 3)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_recherche_client)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_dispo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_search))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_message, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_envoi_message))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_filename, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txt_tentation, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addComponent(jLabel8)
                .addGap(6, 6, 6)
                .addComponent(txt_file_telecharger, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_connexionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_connexionActionPerformed

        if (Integer.parseInt(txt_port.getValue().toString()) < MIN_PORT || 
                Integer.parseInt(txt_port.getValue().toString()) > MAX_PORT) {
            JOptionPane.showMessageDialog(Main.this, "SVP choisissez un port entre " + MIN_PORT + " and " + MAX_PORT);
            return;
        }
        // Connexion au serveur
        new Thread(
            new Runnable() {
            @Override
            public void run() {
                interaction();
            }
        }).start();

        // Les clients Disponible
        new Thread(
                new Runnable() {
            @Override
            public void run() {
                chercher_client_disponible();
            }
        }).start();
    }//GEN-LAST:event_btn_connexionActionPerformed
    private void btn_searchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_searchActionPerformed
        new Thread(new Runnable() {
            @Override
            public void run() {
                chercher_client_disponible();
            }
        }).start();
    }//GEN-LAST:event_btn_searchActionPerformed

    public void interaction(){
        try {
            ServerSocket server = new ServerSocket(Integer.parseInt(txt_port.getValue().toString()));

            confirmtelechargement = false;
            //  mise à jour statut composants graphique
            btn_connexion.setEnabled(false);
            txt_dispo.setEnabled(true);
            txt_file_telecharger.setEnabled(true);
            txt_tentation.setEnabled(true);
            txt_filename.setEnabled(true);
            txt_knowed.setEnabled(true);

            port = txt_port.getValue().toString();
            host = txt_host.getText();
            txt_connexion_etat.setText("Connecté");
            txt_connexion_etat.setForeground(new Color(23, 255, 0));

            while (true) { // boucle infinie pour attendre d'autres connexion
                Socket s = server.accept();
                boolean reponse_pair = true;
                InputStream inputStream = s.getInputStream();

                String string = "";
                // tester si on est pas en attente d'un téléchargement d'un fichier
                if (!confirmtelechargement) {
                    // Lire les données
                    data_is = new DataInputStream(inputStream);
                    string = (String) data_is.readUTF();
                } else {
                        try {
                            // The downloaded block
                            reponse_pair = false;
                            // initialisation pour reçevoir les données
                            data_is = new DataInputStream(inputStream);
                            bf = new BufferedReader(new InputStreamReader(inputStream));
                                
                            final String filename = bf.readLine(); // le nom du fichier
                            final long fileSize = Long.parseLong(bf.readLine()); // la taille du fichier

                            // parcourir le répertoire ou stocker le fichier
                            fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
                            fileChooser.setDialogTitle("choisissez le dossier dans le quel vous allez sauvergader le fichier");
                            int rep = fileChooser.showDialog(null, "choisissez un dossier pour sauvegarder le fichier");
                            File clientDirectory = fileChooser.getCurrentDirectory();
                            File chemin = clientDirectory;
                            if (rep == JFileChooser.APPROVE_OPTION) {
                                chemin = fileChooser.getSelectedFile();
                                clientDirectory = chemin;
                            }
                            directory = chemin;

                            // Show the progress bar
                            progress = new Progression();
                            progress.showDialog();

                            // Thread du téléchargement du fichier
                            new Thread(new Runnable() {
                            @Override
                            public void run() {
                                try {
                                    // début du téléchargement
                                    runProgress(fileSize, directory, progress, filename);
                                    data_is.close();
                                    } catch (Exception e) {
                                        e.printStackTrace();
                                    }
                                progress.closeDialog();
                            }
                            }).start();
                            confirmtelechargement = false;
                            // en attente pour d'autre informations
                            break;
                            } catch (Exception ex) {
                                ex.printStackTrace();
                            }
                        }

                // lire des données reçu
                OutputStream outputStream = s.getOutputStream();
                txt_envoyer.setText("Message reçu: -> " + date_aff.format(new Date()) + " > " + string + "\n" + txt_envoyer.getText());

                String string_reponse = ""; // contient la réponse
                if (string.equals("Name ?")) { // a peer X send this message to all other peers available.
                    // Retourné le nom du pair généré par hasard à partir de la liste name_generated
                    Random rand = new Random();
                    string_reponse = name_generated.get(rand.nextInt(name_generated.size()));
                } else if (string.equals("Known Peer ?")) {
                    // Retourne la liste des pairs connu par un pair A
                    for (ClientConnu item : liste_pair_connus) {
                        string_reponse += item.host + ":" + item.port + ";";
                    }
                } else if (string.startsWith("it's me!")) {
                    // max liste pair connu est de 5
                    if (liste_pair_connus.size() == MAX_LIST_PAIR_CONNUS) { // maximum 5 éléments
                        string_reponse = "Liste pleine";
                    } else {
                        string = string.replaceAll("it's me! ", "");
                        String[] temp = string.split(":");
                        // avant de sauvegarder le pair, tester s'il existe déjà dans sa liste.
                        boolean found = false;
                        for (ClientConnu item : liste_pair_connus) {
                            if (temp[0].equals(item.host) && temp[1].equals(item.port)) {
                                string_reponse = "ce client existe déjà";
                                found = true;
                                break;
                            }
                        }
                        if (!found) { // un nouveau pair à ajouté
                            liste_pair_connus.add(new ClientConnu(temp[0], temp[1]));
                            string_reponse = "Vous venez d'etre ajouter à la liste des clients connus";
                            model.addElement(new ClientConnu(temp[0], temp[1]));
                        }
                    }
                    } else if (string.startsWith("File!")) { // demander un fichier X

                        String[] tmp = string.replaceAll("File! ", "").split(":");
                        reponse_pair = false;
                        if (new File(dossier_actuel + "\\files\\" + port + "\\" + tmp[2]).exists()) { // si le fichier existe
                            try {
                                Socket socket = new Socket(tmp[0], Integer.parseInt(tmp[1]));
                                OutputStream outputStream_tmp = socket.getOutputStream();
                                DataOutputStream dataOutputStream = new DataOutputStream(outputStream_tmp);
                                dataOutputStream.writeUTF("Voila! " + tmp[0] + ":" + tmp[1] + ":" + tmp[2] + ":" + host + ":" + port); // notifié avec le message 'voilà'
                                txt_envoyer.setText("Message envoyer: ->" + date_aff.format(new Date()) + " > " + "Voila! " + tmp[0] + ":" + tmp[1] + ":" + tmp[2] + ":" + host + ":" + port + "\n" + txt_envoyer.getText());
                                dataOutputStream.flush();
                                dataOutputStream.close();
                                } catch (Exception e) {
                                }

                            } else { // le fichier n'existe pas donc on cherche dans la liste des pairs connus
                                tmp[3] = (Integer.parseInt(tmp[3]) - 1) + "";
                                if (liste_pair_connus.isEmpty()) { // la liste des pairs connus ne contient pas le fichier
                                    try {
                                        Socket socket = new Socket(tmp[0], Integer.parseInt(tmp[1]));
                                        OutputStream outputStream_tmp = socket.getOutputStream();
                                        DataOutputStream dataOutputStream = new DataOutputStream(outputStream_tmp);
                                        dataOutputStream.writeUTF("Fichier introuvable ! " + tmp[2]);
                                        txt_envoyer.setText("Message envoyer: ->" + date_aff.format(new Date()) + " > " + "Fichier introuvable ! " + tmp[2] + "\n" + txt_envoyer.getText());
                                        dataOutputStream.flush();
                                        dataOutputStream.close();
                                    } catch (Exception e) {
                                    }
                                } else { // fichier trouvé dans la liste des pairs connus
                                    if (Integer.parseInt(tmp[3]) != 0) {
                                        for (ClientConnu item : liste_pair_connus) {
                                            try {
                                                Socket socket = new Socket(item.host, Integer.parseInt(item.port));
                                                OutputStream outputStream_tmp = socket.getOutputStream();
                                                DataOutputStream dataOutputStream = new DataOutputStream(outputStream_tmp);
                                                txt_envoyer.setText("Message envoyer: ->" + date_aff.format(new Date()) + " >> " + string + "\n" + txt_envoyer.getText());
                                                dataOutputStream.writeUTF("File! " + tmp[0] + "->" + tmp[1] + "->" + tmp[2] + "->" + tmp[3]);
                                                dataOutputStream.flush();
                                                dataOutputStream.close();
                                            } catch (Exception e) {
                                            }
                                        }
                                        reponse_pair = false;
                                    } else {// fichier introuvable
                                        try {
                                            Socket socket = new Socket(tmp[0], Integer.parseInt(tmp[1]));
                                            OutputStream outputStream_tmp = socket.getOutputStream();
                                            DataOutputStream dataOutputStream = new DataOutputStream(outputStream_tmp);
                                            dataOutputStream.writeUTF("Fichier introuvable ! " + tmp[2]);
                                            txt_envoyer.setText("Message envoyer: ->" + date_aff.format(new Date()) + " >> " + "Fichier introuvable ! " + tmp[2] + "\n" + txt_envoyer.getText());
                                            dataOutputStream.flush();
                                            dataOutputStream.close();
                                        } catch (Exception e) {
                                        }
                                    }
                                }
                            }
                        } else if (string.startsWith("Voila!")) {
                            txt_file_telecharger.addItem(string.replaceAll("Voila! ", ""));
                            reponse_pair = false;
                        } else if (string.startsWith("Download !")) {
                            String[] tmp = string.replaceAll("Download ! ", "").split(":");
                            // tester si le fichier existe
                            if (!new File(dossier_actuel + "\\files\\" + port + "\\" + tmp[2]).exists()) {
                                string_reponse = "Fichier introuvable";
                            } else {
                                reponse_pair = false;
                                File file = new File(dossier_actuel + "\\files\\" + port + "\\" + tmp[2]);

                                Socket socket = new Socket(tmp[0], Integer.parseInt(tmp[1]));
                                DataOutputStream output = new DataOutputStream(socket.getOutputStream());
                                PrintWriter clientPW = new PrintWriter(output, true);

                                long fileLength = file.length();
                                FileInputStream fileReader = new FileInputStream(file);
                                BufferedInputStream bufferedFileReader = new BufferedInputStream(fileReader);

                                clientPW.println(file.getName()); // nom du fichier
                                clientPW.println(fileLength); // la taille du fichier

                                // envoyer les données
                                Main.envoyer_octets(bufferedFileReader, output);

                                // Fermeture des connexions
                                bufferedFileReader.close();
                                fileReader.close();
                                output.flush();
                                clientPW.flush();
                                output.close();
                                clientPW.close();
                                txt_envoyer.setText("Message envoyer: ->" + date_aff.format(new Date()) + " >> " + "Start " + file.getName() + " (" + fileLength + " bytes)\n" + txt_envoyer.getText());

                            }
                        } else if (string.startsWith("bye !")) { // déconnexion d'un client
                            String[] tmp = string.replaceAll("bye ! ", "").split(":");
                            boolean pair_trouve = false;
                            for (int i = 0; i < model.size(); i++) {
                                if (tmp[0].equals(model.get(i).host) && tmp[1].equals(model.get(i).port)) {
                                    model.remove(i);
                                    pair_trouve = true;
                                    break;
                                }
                            }
                            actualiser_liste_pair_connu();
                            if (pair_trouve) {
                                // envoyé les informations aux pairs connus.
                                for (ClientConnu item : liste_pair_connus) {
                                    try {
                                        Socket socket = new Socket(host, Integer.parseInt(item.port));
                                        OutputStream outputStream_tmp = socket.getOutputStream();
                                        DataOutputStream dataOutputStream = new DataOutputStream(outputStream_tmp);
                                        txt_envoyer.setText("Message envoyer: ->" + date_aff.format(new Date()) + " >> " + item.port + " : " + string + "\n" + txt_envoyer.getText());
                                        dataOutputStream.writeUTF(string);
                                        dataOutputStream.flush();
                                        dataOutputStream.close();
                                    } catch (Exception e) {
                                    }
                                }
                                string_reponse = "A bientôt :)";
                            }
                        }

                        if (reponse_pair) { // envoi de la réponse
                            DataOutputStream dataOutputStream = new DataOutputStream(outputStream);
                            txt_envoyer.setText("Message envoyer: ->" + date_aff.format(new Date()) + " >>" + string_reponse + "\n" + txt_envoyer.getText());
                            dataOutputStream.writeUTF(string_reponse);
                            dataOutputStream.flush();
                            dataOutputStream.close();
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    txt_connexion_etat.setText(e.getLocalizedMessage());
                    txt_connexion_etat.setForeground(new Color(255, 0, 0));
                    JOptionPane.showMessageDialog(Main.this, "Déconnecté");
                }

    } // fin méthode interaction
    public void runProgress(long taille_fichier, File directory, Progression progress, String filename) throws IOException {

        byte[] data = new byte[4096];
        File f = new File(directory, filename);

        FileOutputStream fileOut = new FileOutputStream(f);
        DataOutputStream dataOut = new DataOutputStream(fileOut);

        long totalDown = 0;
        long tailleFichier = taille_fichier;
        int compteur;

        while ((compteur = data_is.read(data, 0, (int) Math.min((long) data.length, tailleFichier))) > 0) {
            totalDown += compteur;
            tailleFichier -= compteur;
            final int pourcent = (int) (totalDown * 100 / taille_fichier);

            progress.updateBar(pourcent);

            if (taille_fichier < 1e3) {
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } else if (taille_fichier < 1e6) {
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            dataOut.write(data, 0, compteur);
        }
        fileOut.close();
    }

    public void actualiser_liste_pair_connu() { // methode pour actualiser la liste des clients disponible
        model = new DefaultListModel<>();
        for (ClientConnu item : liste_pair_connus) {
            model.addElement(new ClientConnu(item.host, item.port));
        }
    }

    private void btn_envoi_messageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_envoi_messageActionPerformed

        try {
            if (txt_message.getSelectedIndex() == 0) {
                JOptionPane.showMessageDialog(this, "S.V.P faites votre choix !");
                return;
            }
            new Thread(new Runnable() {
                @Override
                public void run() {
                    menu_principale();
                }
            }).start();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }//GEN-LAST:event_btn_envoi_messageActionPerformed
    public void menu_principale(){
        try {
            // Connect the client socket with txt_available
            Socket socket = new Socket(host, Integer.parseInt(txt_dispo.getSelectedItem().toString()));
            boolean reponse_menu = true;
            OutputStream outputStream = socket.getOutputStream();
            DataOutputStream dataOutputStream = new DataOutputStream(outputStream);
            String messagEnvoyer = txt_message.getSelectedItem().toString();
            switch (messagEnvoyer) {
                case "it's me!":
                    messagEnvoyer += " " + host + ":" + port;
                    break;
                case "bye !":
                    messagEnvoyer += " " + host + ":" + port;
                    break;
                case "File!":
                    if (txt_filename.getText().length() > 3 && Integer.parseInt(txt_tentation.getValue().toString()) > 0) {
                        messagEnvoyer += " " + host + ":" + port + ":" + txt_filename.getText() + ":" + Integer.parseInt(txt_tentation.getValue().toString());
                    } else {
                            JOptionPane.showMessageDialog(Main.this, "Tapez un nom de fichier valide SVP !");
                            return;
                           }
                    reponse_menu = false;
                    break;
                case "Download !":
                    if (txt_file_telecharger.getItemCount() == 0) {
                        JOptionPane.showMessageDialog(Main.this, "No file available to download\nPlease send the FILE message to search for a file");
                        return;
                    }
                    messagEnvoyer += " " + txt_file_telecharger.getSelectedItem().toString();
                    confirmtelechargement = true;
                    reponse_menu = false;
                    break;
            }

                        // envoi des données à la socket
                        txt_envoyer.setText("Message envoyer: ->" + date_aff.format(new Date()) + " > " + txt_dispo.getSelectedItem() + " : " + messagEnvoyer + "\n" + txt_envoyer.getText());
                        dataOutputStream.writeUTF(messagEnvoyer);
                        dataOutputStream.flush();
                        // attente de réponse
                        if (reponse_menu) {
                            DataInputStream dis = new DataInputStream(socket.getInputStream());
                            txt_envoyer.setText("Message reçu: -> " + date_aff.format(new Date()) + " >> " + txt_dispo.getSelectedItem() + " : " + (String) dis.readUTF() + "\n" + txt_envoyer.getText());
                        }
                        dataOutputStream.close();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
    }
    private void txt_messageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_messageActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_messageActionPerformed

    private void txt_dispoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_dispoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_dispoActionPerformed

    private void txt_hostActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_hostActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_hostActionPerformed

    public static boolean isSocketRunning(int port) { // tester si la socket est toujours en execution

        ServerSocket serv_socket = null;
        DatagramSocket datagram_socket = null;
        try {
            serv_socket = new ServerSocket(port);
            serv_socket.setReuseAddress(true);
            datagram_socket = new DatagramSocket(port);
            datagram_socket.setReuseAddress(true);
            return false;
        } catch (IOException e) {
        } finally {
            if (datagram_socket != null) {
                datagram_socket.close();
            }

            if (serv_socket != null) {
                try {
                    serv_socket.close();
                } catch (IOException e) {
                }
            }
        }
        return true;
    }
    public synchronized void chercher_client_disponible() { // pour chercher les clients connecté
        try {
            txt_dispo.removeAllItems();
            btn_search.setEnabled(false);
            txt_message.setEnabled(false);
            btn_envoi_message.setEnabled(false);
            for (int i = MIN_PORT; i <= MAX_PORT; i++) { // chercher dans les port de 1000 à 2000
                txt_recherche_client.setText("recherche en cours.. : " + i);
                if (i != Integer.parseInt(txt_port.getValue().toString()) && isSocketRunning(i)) {
                    txt_dispo.addItem(new String(i + ""));
                }
            }
            btn_search.setEnabled(true);

            if (txt_dispo.getItemCount() != 0) {
                txt_message.setEnabled(true);
                btn_envoi_message.setEnabled(true);
            }

        } catch (Exception e) {
            e.printStackTrace();
            txt_connexion_etat.setText("Ce port est déjà utilisé par un autre client");
            txt_connexion_etat.setForeground(new Color(255, 0, 0)); // en rouge
        }
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        try {
            // Set System L&F
            UIManager.setLookAndFeel(
                    UIManager.getSystemLookAndFeelClassName());
        } catch (UnsupportedLookAndFeelException e) {
            // handle exception
        } catch (ClassNotFoundException e) {
            // handle exception
        } catch (InstantiationException e) {
            // handle exception
        } catch (IllegalAccessException e) {
            // handle exception
        }

        // affichage de l'interface graphique
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Main().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_connexion;
    private javax.swing.JButton btn_envoi_message;
    private javax.swing.JButton btn_search;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JLabel txt_connexion_etat;
    private javax.swing.JComboBox txt_dispo;
    private javax.swing.JTextPane txt_envoyer;
    private javax.swing.JComboBox txt_file_telecharger;
    private javax.swing.JTextField txt_filename;
    private javax.swing.JTextField txt_host;
    private javax.swing.JList txt_knowed;
    private javax.swing.JComboBox txt_message;
    private javax.swing.JSpinner txt_port;
    private javax.swing.JLabel txt_recherche_client;
    private javax.swing.JSpinner txt_tentation;
    // End of variables declaration//GEN-END:variables
}
