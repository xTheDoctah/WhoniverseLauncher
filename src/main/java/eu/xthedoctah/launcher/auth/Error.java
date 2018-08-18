package eu.xthedoctah.launcher.auth;

import eu.xthedoctah.launcher.utils.ToJson;

public class Error extends ToJson {
    private static Error istanza;
    private String error;
    private String errorMessage;

    public Error() {
    }

    public static Error getInstance() {
        if (istanza == null) {
            istanza = new Error();
        }
        return istanza;
    }

    public static void setInstance(Error istanza2) {
        istanza = istanza2;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}
