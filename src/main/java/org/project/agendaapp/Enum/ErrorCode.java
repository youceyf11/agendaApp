package org.project.agendaapp.Enum;

import lombok.Getter;


public enum ErrorCode {

    // Erreurs techniques
    INVALID_UUID("Format UUID invalide"),
    DATABASE_ERROR("Erreur lors de l'accès à la base de données"),
    TECHNICAL_ERROR("Erreur technique interne"),

    // Erreurs d'authentification
    AUTHENTICATION_FAILED("Échec de l'authentification"),
    UNAUTHORIZED_ACCESS("Accès non autorisé"),
    SESSION_EXPIRED("Session expirée"),

    // Erreurs Utilisateur
    USER_NOT_FOUND("Utilisateur non trouvé"),
    USER_ALREADY_EXISTS("Utilisateur déjà existant"),
    INVALID_CREDENTIALS("Identifiants invalides"),
    PASSWORD_ENCODING_ERROR("Erreur lors du cryptage du mot de passe"),
    VALIDATION_ERROR("Erreur de validation des données utilisateur"),

    // Erreurs Client
    CLIENT_NOT_FOUND("Client non trouvé"),
    CLIENT_ALREADY_EXISTS("Client déjà existant"),

    // Erreurs Fiche Client
    FICHE_CLIENT_NOT_FOUND("Fiche client non trouvée"),
    FICHE_CLIENT_ALREADY_EXISTS("Fiche client déjà existante"),

    // Erreurs Document Joint
    DOCUMENT_JOINT_NOT_FOUND("Document joint non trouvé"),
    DOCUMENT_JOINT_ALREADY_EXISTS("Document joint déjà existant"),

    // Erreurs Disponibilité
    DISPONIBILITE_NOT_FOUND("Disponibilité non trouvée"),
    DISPONIBILITE_ALREADY_EXISTS("Disponibilité déjà existante"),

    // Erreurs Notification
    NOTIFICATION_NOT_FOUND("Notification non trouvée"),

    // Erreurs Tâche
    TACHE_NOT_FOUND("Tâche non trouvée"),
    TACHE_ALREADY_EXISTS("Tâche déjà existante"),

    PROFESSIONAL_NOT_FOUND("Professionnel non trouvé"),
    PROFESSIONAL_ALREADY_EXISTS("Professionnel déjà existant"),

    RENDEZ_VOUS_NOT_FOUND("Rendez-vous non trouvé"),
    RENDEZ_VOUS_ALREADY_EXISTS("Rendez-vous déjà existant"),

    // Erreurs de validation
    INVALID_DATA("Données invalides"),
    MISSING_REQUIRED_FIELD("Champ obligatoire manquant"),
    DUPLICATE_RECORD("Enregistrement dupliqué");

    private final String message;

    ErrorCode(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}