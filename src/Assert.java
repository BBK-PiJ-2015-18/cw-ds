public class Assert {
    public static void check(Boolean condition, String message) {
        if (condition != true) {
            try {
                throw new Exception(message);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void check(Boolean condition) {
        check(condition, null);
    }

    public static void equals(Object object, Object value) {
        if (object.equals(value) == false) {
            try {
                throw new Exception("Expected " + value.toString() + " but found " + object.toString());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void noError(ReturnObject returnObject) {
        equals(returnObject.getError(), ErrorMessage.NO_ERROR);
    }
}