/*
Copyleft (C) 2005 H�lio Perroni Filho
xperroni@yahoo.com
ICQ: 2490863

This file is part of ChatterBean.

ChatterBean is free software; you can redistribute it and/or modify it under the terms of the GNU General Public License as published by the Free Software Foundation; either version 2 of the License, or (at your option) any later version.

ChatterBean is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU General Public License for more details.

You should have received a copy of the GNU General Public License along with ChatterBean (look at the Documents/ directory); if not, either write to the Free Software Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA  02111-1307 USA, or visit (http://www.gnu.org/licenses/gpl.txt).
*/

package bitoflife.chatterbean;

import java.io.*;
import java.util.Objects;

import bitoflife.chatterbean.parser.AliceBotParser;
import bitoflife.chatterbean.parser.AliceBotParserConfigurationException;
import bitoflife.chatterbean.parser.AliceBotParserException;
import bitoflife.chatterbean.util.Searcher;

public class AliceBotMother {
  /*
  Attribute Section
  */

    private ByteArrayOutputStream gossip;

    private static  AliceBot bot;

    static {
        Searcher searcher = new Searcher();
        AliceBotParser parser = null;
        try {
            parser = new AliceBotParser();
        } catch (AliceBotParserConfigurationException e) {
            e.printStackTrace();
        }
        String path = AliceBotMother.class.getClassLoader().getResource("").getPath();
        try {
            bot = Objects.requireNonNull(parser).parse(new FileInputStream(path + File.separator + "Bots/context.xml"),
                    new FileInputStream(path + File.separator +  "Bots/splitters.xml"),
                    new FileInputStream(path + File.separator +  "Bots/substitutions.xml"),
                    searcher.search(path + File.separator +  "Bots/aimlfile", ".*\\.aiml"));
        } catch (AliceBotParserException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Context context = bot.getContext();
        context.outputStream( new ByteArrayOutputStream());
    }
      /*
      Event Section
      */

    public void setUp() {
        gossip = new ByteArrayOutputStream();
    }
  
  /*
  Method Section
  */

    public String gossip() {
        return gossip.toString();
    }


    public static AliceBot newInstance() {
        return  bot;
    }
}
