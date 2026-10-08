import React from 'react';
import { useState } from 'react';
import {
  SafeAreaView,
  ScrollView,
  StyleSheet,
  Text,
  View,
  Pressable,
  Linking,
  StatusBar,
} from 'react-native';

const profile = {
  name: 'Toxic Sabbir',
  handle: '@Toxic-Sabbir',
  title: 'Developer • Automation • AI • Bot & App Experiments',
  bio: 'I build automation tools, AI-powered experiments, and software prototypes with a strong focus on creative product ideas and practical developer workflows.',
  skills: [
    'Kotlin',
    'Jetpack Compose',
    'Android',
    'JavaScript',
    'Python',
    'Node.js',
    'Automation',
    'AI Tools',
    'Bot Development',
    'Selenium',
    'Web Apps',
  ],
  projects: [
    {
      name: 'AIRAVAT-PRO',
      description: 'A product-style project focused on automation and smart software experiences.',
      stack: ['Android', 'Automation', 'AI'],
    },
    {
      name: 'anubisbot-MD',
      description: 'WhatsApp bot project using a Node.js stack for automation and messaging workflows.',
      stack: ['Node.js', 'Bots', 'Automation'],
    },
    {
      name: 'autoFB',
      description: 'Browser automation experiments built around Selenium and web interaction flows.',
      stack: ['Python', 'Selenium', 'Automation'],
    },
    {
      name: 'Chatgptweb',
      description: 'AI interface experiments centered around conversation-driven web experiences.',
      stack: ['TypeScript', 'AI', 'Web'],
    },
    {
      name: 'GhostTrack',
      description: 'Utility and tracking-focused project exploring practical, data-driven tooling.',
      stack: ['Python', 'Tracking', 'Utilities'],
    },
    {
      name: 'DogeRat',
      description: 'Android and remote-control related experimental project from the GitHub profile history.',
      stack: ['Android', 'Security', 'Automation'],
    },
  ],
  links: [
    { label: 'GitHub', url: 'https://github.com/Toxic-Sabbir' },
    { label: 'Repositories', url: 'https://github.com/Toxic-Sabbir?tab=repositories' },
    { label: 'Email', url: 'mailto:toxicsabbir.dev@gmail.com' },
  ],
};

export default function App() {
  const [selectedTab, setSelectedTab] = useState('Profile');

  const openLink = (url) => {
    Linking.openURL(url);
  };

  return (
    <SafeAreaView style={styles.container}>
      <StatusBar barStyle="light-content" backgroundColor="#0B1020" />
      <ScrollView contentContainerStyle={styles.scrollContent}>
        <View style={styles.headerCard}>
          <View style={styles.topRow}>
            <View style={styles.avatar}>
              <Text style={styles.avatarText}>TS</Text>
            </View>
            <Pressable
              style={styles.primaryButton}
              onPress={() => openLink('https://github.com/Toxic-Sabbir')}
            >
              <Text style={styles.primaryButtonText}>GitHub</Text>
            </Pressable>
          </View>

          <Text style={styles.name}>{profile.name}</Text>
          <Text style={styles.handle}>{profile.handle}</Text>
          <Text style={styles.title}>{profile.title}</Text>

          <View style={styles.chipRow}>
            {['Portfolio', 'Open to build'].map((item) => (
              <View key={item} style={styles.chip}>
                <Text style={styles.chipText}>{item}</Text>
              </View>
            ))}
          </View>
        </View>

        <View style={styles.card}>
          <Text style={styles.sectionTitle}>About</Text>
          <Text style={styles.bodyText}>{profile.bio}</Text>
        </View>

        <View style={styles.card}>
          <Text style={styles.sectionTitle}>Core Skills</Text>
          <View style={styles.skillWrap}>
            {profile.skills.map((skill) => (
              <View key={skill} style={styles.skillChip}>
                <Text style={styles.skillText}>{skill}</Text>
              </View>
            ))}
          </View>
        </View>

        <View style={styles.card}>
          <Text style={styles.sectionTitle}>Featured Projects</Text>
          {profile.projects.map((project) => (
            <View key={project.name} style={styles.projectCard}>
              <Text style={styles.projectTitle}>{project.name}</Text>
              <Text style={styles.bodyText}>{project.description}</Text>
              <View style={styles.projectStackWrap}>
                {project.stack.map((tag) => (
                  <View key={tag} style={styles.tagChip}>
                    <Text style={styles.tagText}>{tag}</Text>
                  </View>
                ))}
              </View>
            </View>
          ))}
        </View>

        <View style={styles.card}>
          <Text style={styles.sectionTitle}>Contact</Text>
          {profile.links.map((link) => (
            <Pressable
              key={link.label}
              style={styles.contactButton}
              onPress={() => openLink(link.url)}
            >
              <Text style={styles.contactText}>{link.label}</Text>
            </Pressable>
          ))}
        </View>
      </ScrollView>
    </SafeAreaView>
  );
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
    backgroundColor: '#0B1020',
  },
  scrollContent: {
    padding: 16,
    paddingBottom: 28,
  },
  headerCard: {
    backgroundColor: '#111827',
    borderRadius: 24,
    padding: 20,
    marginBottom: 18,
    borderWidth: 1,
    borderColor: '#2A334A',
    backgroundColor: '#1F2A44',
  },
  topRow: {
    flexDirection: 'row',
    justifyContent: 'space-between',
    alignItems: 'center',
    marginBottom: 16,
  },
  avatar: {
    width: 72,
    height: 72,
    borderRadius: 36,
    backgroundColor: '#111827',
    justifyContent: 'center',
    alignItems: 'center',
  },
  avatarText: {
    color: '#FFFFFF',
    fontSize: 24,
    fontWeight: '700',
  },
  primaryButton: {
    backgroundColor: 'rgba(255,255,255,0.12)',
    paddingHorizontal: 16,
    paddingVertical: 10,
    borderRadius: 12,
  },
  primaryButtonText: {
    color: '#FFFFFF',
    fontWeight: '600',
  },
  name: {
    color: '#FFFFFF',
    fontSize: 32,
    fontWeight: '800',
    marginBottom: 4,
  },
  handle: {
    color: '#E5E7EB',
    fontSize: 16,
    marginBottom: 4,
  },
  title: {
    color: '#D1D5DB',
    fontSize: 14,
    marginBottom: 16,
  },
  chipRow: {
    flexDirection: 'row',
    flexWrap: 'wrap',
    gap: 8,
  },
  chip: {
    backgroundColor: 'rgba(255,255,255,0.08)',
    borderRadius: 999,
    paddingHorizontal: 12,
    paddingVertical: 8,
  },
  chipText: {
    color: '#FFFFFF',
    fontSize: 12,
    fontWeight: '600',
  },
  card: {
    backgroundColor: '#111827',
    borderRadius: 22,
    padding: 18,
    marginBottom: 18,
    borderWidth: 1,
    borderColor: '#2A334A',
  },
  sectionTitle: {
    color: '#FFFFFF',
    fontSize: 22,
    fontWeight: '700',
    marginBottom: 10,
  },
  bodyText: {
    color: '#B3C1D9',
    fontSize: 15,
    lineHeight: 22,
  },
  skillWrap: {
    flexDirection: 'row',
    flexWrap: 'wrap',
    gap: 8,
  },
  skillChip: {
    backgroundColor: '#7C3AED22',
    borderRadius: 999,
    paddingHorizontal: 12,
    paddingVertical: 8,
    marginRight: 6,
    marginBottom: 6,
  },
  skillText: {
    color: '#A78BFA',
    fontSize: 12,
    fontWeight: '700',
  },
  projectCard: {
    backgroundColor: '#1A2235',
    borderRadius: 16,
    padding: 14,
    marginTop: 12,
    borderWidth: 1,
    borderColor: '#2A334A',
  },
  projectTitle: {
    color: '#FFFFFF',
    fontSize: 18,
    fontWeight: '700',
    marginBottom: 8,
  },
  projectStackWrap: {
    flexDirection: 'row',
    flexWrap: 'wrap',
    marginTop: 10,
    gap: 6,
  },
  tagChip: {
    backgroundColor: '#FFFFFF14',
    borderRadius: 999,
    paddingHorizontal: 10,
    paddingVertical: 6,
  },
  tagText: {
    color: '#E5E7EB',
    fontSize: 11,
    fontWeight: '600',
  },
  contactButton: {
    backgroundColor: '#FFFFFF12',
    paddingVertical: 12,
    paddingHorizontal: 14,
    borderRadius: 12,
    marginTop: 10,
  },
  contactText: {
    color: '#FFFFFF',
    fontSize: 14,
    fontWeight: '600',
    textAlign: 'center',
  },
});
