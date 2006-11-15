package ca.sqlpower.architect;

import java.io.File;
import java.io.IOException;
import java.util.List;

public interface DataSourceCollection {

    public static final String DOS_CR_LF = "\r\n";

    /**
     * Reads the PL.INI file at the given location into a new fileSections list.
     * Also updates the fileTime.
     */
    public void read(File location) throws IOException;

    /**
     * Writes out every section in the fileSections list in the
     * order they appear in that list.
     *
     * @param location The location to write to.
     * @throws IOException if the location is not writeable for any reason.
     */
    public void write(File location) throws IOException;

    /**
     * Searches the list of connections for one with the given name.
     *
     * @param name The Logical datbabase name to look for.
     * @return the first ArchitectDataSource in the file whose name matches the
     * given name, or null if no such datasource exists.
     */
    public ArchitectDataSource getDataSource(String name);

    /**
     * @return a sorted List of all the data sources in this pl.ini.
     */
    public List<ArchitectDataSource> getConnections();

    public String toString();

    /**
     * Adds a new data source to the end of this file's list of sections.
     *
     * @param dbcs The new data source to add
     */
    public void addDataSource(ArchitectDataSource dbcs);

    /**
     * Make sure an ArchitectDataSource is in the master list; either copy its properties
     * to one with the same name found in the list, OR, add it to the list.
     * @param dbcs
     */
    public void mergeDataSource(ArchitectDataSource dbcs);

    public void removeDataSource(ArchitectDataSource dbcs);

    public void addDatabaseListChangeListener(DatabaseListChangeListener l);

    public void removeDatabaseListChangeListener(DatabaseListChangeListener l);

}