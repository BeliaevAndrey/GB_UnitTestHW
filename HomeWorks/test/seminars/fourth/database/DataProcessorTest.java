package seminars.fourth.database;


import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

class DataProcessorTest {
    @Test
    void testDataProcessor() {
        ArrayList<String> expected = new ArrayList<>() {{
            add("new String1");
            add("new String2");
            add("new String3");
        }};

        Database db = mock(Database.class);
        DataProcessor dp = new DataProcessor(db);

        when(db.query(anyString())).thenReturn(new ArrayList<>() {{
            add("new String1");
            add("new String2");
            add("new String3");
        }});

        List result = dp.processData(anyString());

        verify(db, times(1)).query(anyString());
        assertThat(result).isNotEmpty().hasSize(3).isEqualTo(expected);
    }
}