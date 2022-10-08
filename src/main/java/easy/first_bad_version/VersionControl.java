package easy.first_bad_version;

public class VersionControl {
    private int badVersion = 1;
    private int calls = 0;

    public int getCalls() {
        int c = calls;
        calls = 0;
        return c;
    }

    boolean isBadVersion(int version){calls++; return  version >= badVersion;}
    public void setBadVersion(int badVersion) {
        this.badVersion = badVersion;
    }
}
